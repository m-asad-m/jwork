package MuhammadAsadMuyassir.jwork.database;

import MuhammadAsadMuyassir.jwork.object.Bonus;
import MuhammadAsadMuyassir.jwork.exception.BonusNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.ReferralCodeAlreadyExistsException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class DatabaseBonusPostgre adalah class yang melakukan seluruh query bonus
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class DatabaseBonusPostgre {
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Metode untuk mendapatkan seluruh bonus yang ada pada database
     *
     * @return array list seluruh bonus
     */
    public static ArrayList<Bonus> getBonus()
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Bonus> returnValue = new ArrayList<>();

            stmt = conn.createStatement();
            String sql = "SELECT * FROM bonus;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                returnValue.add( new Bonus(
                        rs.getInt("bonus_id"),
                        rs.getString("referral_code"),
                        rs.getInt("extra_fee"),
                        rs.getInt("min_total_fee"),
                        rs.getBoolean("active")
                ));
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk mendapatkan bonus berdasarkan id
     *
     * @param id                        id bonus
     * @return                          objek bonus
     * @throws BonusNotFoundException   jika id tidak ditemukan dalam database
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM bonus WHERE bonus_id = %d;",
                    id
            );
            ResultSet rs = stmt.executeQuery(sql);
            Bonus returnValue;
            if(rs.next()) {
                returnValue = new Bonus(
                        rs.getInt("bonus_id"),
                        rs.getString("referral_code"),
                        rs.getInt("extra_fee"),
                        rs.getInt("min_total_fee"),
                        rs.getBoolean("active")
                );
            } else {
                rs.close();
                stmt.close();
                conn.close();
                throw new BonusNotFoundException(id);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (BonusNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk mendapatkan bonus berdasarkan kode referral
     *
     * @param referralCode              kode referral
     * @return                          objek bonus
     * @throws BonusNotFoundException   jika kode referral tidak ditemukan dalam database
     */
    public static Bonus getBonusByReferralCode(String referralCode) throws BonusNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM bonus WHERE referral_code = '%s';",
                    referralCode
            );
            ResultSet rs = stmt.executeQuery(sql);
            Bonus returnValue;
            if(rs.next()) {
                 returnValue = new Bonus(
                         rs.getInt("bonus_id"),
                         rs.getString("referral_code"),
                         rs.getInt("extra_fee"),
                         rs.getInt("min_total_fee"),
                         rs.getBoolean("active")
                );
            } else {
                rs.close();
                stmt.close();
                conn.close();
                throw new BonusNotFoundException(referralCode);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (BonusNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk menambahkan bonus ke dalam database
     *
     * @param bonus                                 objek bonus
     * @return                                      boolean status keberhasilan
     * @throws ReferralCodeAlreadyExistsException   jika kode referral sudah terdapat dalam database
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "INSERT INTO bonus (referral_code, extra_fee, min_total_fee, active) VALUES ('%s', %d, %d, %b);",
                    bonus.getReferralCode().replace("'", "''"),
                    bonus.getExtraFee(),
                    bonus.getMinTotalFee(),
                    bonus.getActive()
            );
            int res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return res != 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            if(e.getMessage().matches("(?s).*referral_code.*already exists.*")) {
                throw new ReferralCodeAlreadyExistsException(bonus);
            }
            return false;
        }
    }

    /**
     * Metode untuk mengubah status aktif bonus
     *
     * @param id                        id bonus
     * @param status                    status aktif
     * @return                          boolean status keberhasilan
     * @throws BonusNotFoundException   jika id tidak ditemukan dalam database
     */
    public static boolean setBonusStatus(int id, boolean status) throws BonusNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "UPDATE bonus SET active = %b WHERE bonus_id = %d;",
                    status,
                    id
            );
            int res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            if(res == 0) {
                throw new BonusNotFoundException(id);
            } else {
                return true;
            }
        } catch (BonusNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }

    /**
     * Metode untuk menghapus bonus dari database
     *
     * @param id                        id bonus
     * @return                          boolean status keberhasilan
     * @throws BonusNotFoundException   jika id tidak ditemukan dalam database
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "DELETE FROM bonus WHERE bonus_id = %d;",
                    id
            );
            int res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            if(res == 0) {
                throw new BonusNotFoundException(id);
            } else {
                return true;
            }
        } catch (BonusNotFoundException e) {
            throw e;
        }  catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }
}

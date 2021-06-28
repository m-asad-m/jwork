package MuhammadAsadMuyassir.jwork.database;

import MuhammadAsadMuyassir.jwork.object.Location;
import MuhammadAsadMuyassir.jwork.object.Recruiter;
import MuhammadAsadMuyassir.jwork.exception.RecruiterNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.EmailAlreadyExistsException;
import MuhammadAsadMuyassir.jwork.exception.PhoneNumberAlreadyExistsException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Class DatabaseRecruiterPostgre adalah class yang melakukan seluruh query perekrut
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class DatabaseRecruiterPostgre {
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Metode untuk mendapatkan seluruh perekrut yang ada pada database
     *
     * @return array list seluruh perekrut
     */
    public static ArrayList<Recruiter> getRecruiter()
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Recruiter> returnValue = new ArrayList<>();

            stmt = conn.createStatement();
            String sql = "SELECT * FROM recruiter NATURAL JOIN location;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                returnValue.add(new Recruiter(
                        rs.getInt("recruiter_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        new Location(
                                rs.getString("province"),
                                rs.getString("city"),
                                rs.getString("description")
                        )
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
     * Metode untuk mendapatkan perekrut berdasarkan id
     *
     * @param id                            id perekrut
     * @return                              objek perekrut
     * @throws RecruiterNotFoundException   jika id tidak ditemukan dalam database
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM recruiter NATURAL JOIN location WHERE recruiter_id = %d;",
                    id
            );
            ResultSet rs = stmt.executeQuery(sql);
            Recruiter returnValue;
            if(rs.next()) {
                returnValue = new Recruiter(
                        rs.getInt("recruiter_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        new Location(
                                rs.getString("province"),
                                rs.getString("city"),
                                rs.getString("description")
                        )
                );
            } else {
                throw new RecruiterNotFoundException(id);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (RecruiterNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk menambahkan perekrut ke dalam database
     *
     * @param recruiter                             objek perekrut
     * @return                                      boolean status keberhasilan
     * @throws EmailAlreadyExistsException          jika email sudah terdapat dalam database
     * @throws PhoneNumberAlreadyExistsException    jika nomor telepon sudah terdapat dalam database
     */
    public static boolean addRecruiter(Recruiter recruiter)
            throws EmailAlreadyExistsException, PhoneNumberAlreadyExistsException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String province = recruiter.getLocation().getProvince().toLowerCase(Locale.ROOT);
            String city = recruiter.getLocation().getCity().toLowerCase(Locale.ROOT);
            String decrtiption = recruiter.getLocation().getDescription();
            String sql = String.format(
                    "SELECT location_id FROM location WHERE province = '%s' AND city = '%s';",
                    province,
                    city
            );
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int res;
            if(rs.getRow() == 0) {
                sql = String.format(
                        "INSERT INTO location (province, city, description) VALUES ('%s', '%s', '%s');",
                        province,
                        city,
                        decrtiption
                );
                res = stmt.executeUpdate(sql);
                if(res != 0) {
                    sql = String.format(
                            "SELECT location_id FROM location WHERE province = '%s' AND city = '%s';",
                            province,
                            city
                    );
                    rs = stmt.executeQuery(sql);
                    rs.next();
                } else {
                    System.err.println("can't add new location");
                    return false;
                }
            }
            sql = String.format(
                    "INSERT INTO recruiter (name, email, phone_number, location_id) VALUES ('%s', '%s', '%s', %d);",
                    recruiter.getName(),
                    recruiter.getEmail(),
                    recruiter.getPhoneNumber(),
                    rs.getInt("location_id")
            );
            res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return res != 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            if(e.getMessage().matches("(?s).*email.*already exists.*")) {
                throw new EmailAlreadyExistsException(recruiter);
            } else if(e.getMessage().matches("(?s).*phone_number.*already exists.*")) {
                throw new PhoneNumberAlreadyExistsException(recruiter);
            }
            return false;
        }
    }

    /**
     * Metode untuk menghapus perekrut dari database
     *
     * @param id                            id perekrut
     * @return                              boolean status keberhasilan
     * @throws RecruiterNotFoundException   jika id tidak ditemukan dalam database
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException
    {
        Location loc = getRecruiterById(id).getLocation();
        String province = loc.getProvince();
        String city = loc.getCity();
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "DELETE FROM recruiter WHERE recruiter_id = %d;",
                    id
            );
            int res = stmt.executeUpdate(sql);
            if(res == 0) {
                stmt.close();
                conn.close();
                throw new RecruiterNotFoundException(id);
            } else {
                try {
                    sql = String.format(
                            "DELETE FROM location WHERE province = '%s' AND city = '%s';",
                            province,
                            city
                    );
                    stmt.executeUpdate(sql);
                } catch (Exception ignored) {}
                stmt.close();
                conn.close();
                return true;
            }
        } catch (RecruiterNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }
}

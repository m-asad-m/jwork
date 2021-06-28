package MuhammadAsadMuyassir.jwork.database;

import MuhammadAsadMuyassir.jwork.object.Jobseeker;
import MuhammadAsadMuyassir.jwork.exception.JobSeekerNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.EmailAlreadyExistsException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class DatabaseJobseekerPostgre adalah class yang melakukan seluruh query pencari pekerjaan
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class DatabaseJobseekerPostgre {
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Metode untuk mendapatkan seluruh pencari pekerjaan yang ada pada database
     *
     * @return array list seluruh pencari pekerjaan
     */
    public static ArrayList<Jobseeker> getJobseeker()
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Jobseeker> returnValue = new ArrayList<>();
            Calendar calendar = Calendar.getInstance();

            stmt = conn.createStatement();
            String sql = "SELECT * FROM jobseeker;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                calendar.setTime(rs.getDate("join_date"));
                returnValue.add( new Jobseeker(
                        rs.getInt("jobseeker_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        calendar
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
     * Metode untuk mendapatkan pencari pekerjaan berdasarkan id
     *
     * @param id                            id pencari pekerjaan
     * @return                              objek pencari pekerjaan
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database
     */
    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM jobseeker WHERE jobseeker_id = %d;",
                    id
            );
            ResultSet rs = stmt.executeQuery(sql);
            Jobseeker returnValue;
            if(rs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("join_date"));
                returnValue = new Jobseeker(
                        rs.getInt("jobseeker_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        calendar
                );
            } else {
                rs.close();
                stmt.close();
                conn.close();
                throw new JobSeekerNotFoundException(id);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (JobSeekerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk mendapatkan id terakhir
     * @return  integer id
     */
    public static int getLastJobseekerID()
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT jobseeker_id FROM jobseeker ORDER BY jobseeker_id DESC LIMIT 1;";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            int returnValue = rs.getInt("jobseeker_id");
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return 0;
        }
    }

    /**
     * Metode untuk menghapus pencari pekerjaan dari database
     *
     * @param id                            id pencari pekerjaan
     * @return                              boolean status keberhasilan
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database
     */
    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "DELETE FROM jobseeker WHERE jobseeker_id = %d;",
                    id
            );
            int res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            if(res == 0) {
                throw new JobSeekerNotFoundException(id);
            } else {
                return true;
            }
        } catch (JobSeekerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }

    /**
     * Metode untuk menambahkan pencari pekerjaan ke dalam database
     *
     * @param jobseeker                     objek pencari pekerjaan
     * @return                              integer id pencari pekerjaan yang baru tidambahkan
     * @throws EmailAlreadyExistsException  jika email sudah terdapat dalam database
     */
    public static int addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException
    {
        if (jobseeker.getEmail().isBlank()) {
            System.out.println("Email anda tidak sesuai dengan pola yang benar");
            return 0;
        } else if (jobseeker.getPassword().isBlank()) {
            System.out.println("Password anda tidak sesuai dengan pola yang benar");
            return 0;
        } else {
            conn = DatabaseConnectionPostgre.connection();
            try {
                stmt = conn.createStatement();
                String sql = String.format(
                        "INSERT INTO jobseeker (name, email, password, join_date) VALUES ('%s', '%s', '%s', '%s')  RETURNING jobseeker_id;",
                        jobseeker.getName().replace("'", "''"),
                        jobseeker.getEmail(),
                        jobseeker.getPassword().replace("'", "''"),
                        jobseeker.getJoinDate().getTime()
                );
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                int jobseekerId = rs.getInt("jobseeker_id");
                rs.close();
                stmt.close();
                conn.close();
                System.out.println("Jobseeker added successfully!");
                return jobseekerId;
            } catch (Exception e) {
                if(e.getMessage().matches("(?s).*email.*already exists.*")) {
                    throw new EmailAlreadyExistsException(jobseeker);
                } else {
                    System.err.println(e.getClass().getName()+": "+ e.getMessage());
                }
                return 0;
            }
        }
    }

    /**
     * Metode untuk melakukan login pencari pekerjaan
     *
     * @param email                         email pencari pekerjaan
     * @param password                      password pencari pekerjaan
     * @return                              objek pencari pekerjaan
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database
     */
    public static Jobseeker jobseekerLogin(String email, String password) throws JobSeekerNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM jobseeker WHERE email = '%s' AND password = '%s';",
                    email,
                    password
            );
            ResultSet rs = stmt.executeQuery(sql);
            Jobseeker returnValue;
            if(rs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("join_date"));
                returnValue = new Jobseeker(
                        rs.getInt("jobseeker_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        calendar
                );
            } else {
                rs.close();
                stmt.close();
                conn.close();
                throw new JobSeekerNotFoundException(email);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (JobSeekerNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }
}

package MuhammadAsadMuyassir.jwork.database;

import MuhammadAsadMuyassir.jwork.object.Job;
import MuhammadAsadMuyassir.jwork.object.Location;
import MuhammadAsadMuyassir.jwork.object.Recruiter;
import MuhammadAsadMuyassir.jwork.enumeration.JobCategory;
import MuhammadAsadMuyassir.jwork.exception.JobNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.RecruiterNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class DatabaseJobPostgre adalah class yang melakukan seluruh query pekerjaan
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class DatabaseJobPostgre {
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Metode untuk mendapatkan seluruh pekerjaan yang ada pada database
     *
     * @return array list seluruh pekerjaan
     */
    public static ArrayList<Job> getJob()
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Job> returnValue = new ArrayList<>();

            stmt = conn.createStatement();
            String sql = "SELECT * FROM job NATURAL JOIN recruiter NATURAL JOIN location;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                returnValue.add(new Job(
                        rs.getInt("job_id"),
                        rs.getString("job_name"),
                        new Recruiter(
                            rs.getInt("recruiter_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            new Location(
                                    rs.getString("province"),
                                    rs.getString("city"),
                                    rs.getString("description")
                            )
                        ),
                        rs.getInt("fee"),
                        JobCategory.valueOf(rs.getString("category"))
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
     * Metode untuk mendapatkan pekerjaan berdasarkan id
     *
     * @param id                    id pekerjaan
     * @return                      objek pekerjaan
     * @throws JobNotFoundException jika id tidak ditemukan dalam database
     */
    public static Job getJobById(int id) throws JobNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM job NATURAL JOIN recruiter NATURAL JOIN location WHERE job_id = %d;",
                    id
            );
            ResultSet rs = stmt.executeQuery(sql);
            Job returnValue;
            if(rs.next()) {
                returnValue = new Job(
                        rs.getInt("job_id"),
                        rs.getString("job_name"),
                        new Recruiter(
                                rs.getInt("recruiter_id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                new Location(
                                        rs.getString("province"),
                                        rs.getString("city"),
                                        rs.getString("description")
                                )
                        ),
                        rs.getInt("fee"),
                        JobCategory.valueOf(rs.getString("category"))
                );
            } else {
                rs.close();
                stmt.close();
                conn.close();
                throw new JobNotFoundException(id);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (JobNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk mendapatkan pekerjaan berdasarkan perekrut
     *
     * @param id    id perekrut
     * @return      array list pekerjaan
     */
    public static ArrayList<Job> getJobByRecruiter(int id)
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Job> returnValue = new ArrayList<>();

            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM job NATURAL JOIN recruiter NATURAL JOIN location WHERE recruiter_id = %d;",
                    id
            );
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                returnValue.add(new Job(
                        rs.getInt("job_id"),
                        rs.getString("job_name"),
                        new Recruiter(
                                rs.getInt("recruiter_id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                new Location(
                                        rs.getString("province"),
                                        rs.getString("city"),
                                        rs.getString("description")
                                )
                        ),
                        rs.getInt("fee"),
                        JobCategory.valueOf(rs.getString("category"))
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
     * Metode untuk mendapatkan pekerjaan berdasarkan kategori
     *
     * @param category      enum kategori pekerjaan
     * @return              array list pekerjaan
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Job> returnValue = new ArrayList<>();

            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM job NATURAL JOIN recruiter NATURAL JOIN location WHERE category = '%s';",
                    category.name()
            );
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                returnValue.add(new Job(
                        rs.getInt("job_id"),
                        rs.getString("job_name"),
                        new Recruiter(
                                rs.getInt("recruiter_id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                new Location(
                                        rs.getString("province"),
                                        rs.getString("city"),
                                        rs.getString("description")
                                )
                        ),
                        rs.getInt("fee"),
                        JobCategory.valueOf(rs.getString("category"))
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
     * Metode untuk menambahkan pekerjaan ke dalam database
     *
     * @param job                           objek pekerjaan
     * @param recruiterId                   id perekrut
     * @return                              boolean status keberhasilan
     * @throws RecruiterNotFoundException   jika perekrut tidak ditemukan dalam database
     */
    public static boolean addJob(Job job, int recruiterId) throws RecruiterNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "INSERT INTO job (job_name, fee, category, recruiter_id) VALUES ('%s', %d, '%s', %d);",
                    job.getName(),
                    job.getFee(),
                    job.getCategory().name(),
                    recruiterId
            );
            int res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            return res != 0;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            if(e.getMessage().matches("(?s).*recruiter_id.*not present.*")) {
                throw new RecruiterNotFoundException(recruiterId);
            }
            return false;
        }
    }

    /**
     * Metode untuk menghapus pekerjaan dari database
     *
     * @param id                    id pekerjaan
     * @return                      boolean status keberhasilan
     * @throws JobNotFoundException jika id tidak ditemukan dalam database
     */
    public static boolean removeJob(int id) throws JobNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "DELETE FROM job WHERE job_id = %d;",
                    id
            );
            int res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            if(res == 0) {
                throw new JobNotFoundException(id);
            } else {
                return true;
            }
        } catch (JobNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }
}

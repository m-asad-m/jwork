package MuhammadAsadMuyassir.jwork.database;

import MuhammadAsadMuyassir.jwork.object.Job;
import MuhammadAsadMuyassir.jwork.object.Location;
import MuhammadAsadMuyassir.jwork.object.Recruiter;
import MuhammadAsadMuyassir.jwork.enumeration.JobCategory;
import MuhammadAsadMuyassir.jwork.exception.JobNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class DatabaseJobsPostgre adalah class yang melakukan seluruh query relasi invoice dengan job
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class DatabaseJobsPostgre {
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Metode untuk mendapatkan seluruh pekerjaan berdasarkan list id yang diberikan
     *
     * @return                      array list id job
     * @throws JobNotFoundException jika terdapat job yang tidak ditemukan dalam database
     */
    public static ArrayList<Job> getJobsByJobId(ArrayList<Integer> idList) throws JobNotFoundException
    {
        ArrayList<Job> jobs = new ArrayList<>();
        for(int id: idList) {
            jobs.add(DatabaseJobPostgre.getJobById(id));
        }
        return jobs;
    }

    /**
     * Metode untuk mendapatkan seluruh pekerjaan dari suatu invoice
     *
     * @param id    id invoice
     * @return      array list job
     */
    public static ArrayList<Job> getJobsByInvoice(int id)
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Job> returnValue = new ArrayList<>();

            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM jobs NATURAL JOIN job NATURAL JOIN recruiter NATURAL JOIN location WHERE invoice_id = %d;",
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
     * Metode untuk menambahkan relasi antara invoice dengan pekerjaannya
     *
     * @param invoiceId id invoice
     * @param jobIdList array list id job
     * @return          boolean status keberhasilan
     */
    public static boolean addJobs(int invoiceId, ArrayList<Integer> jobIdList)
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            conn.setAutoCommit(false);
            for (int jobId : jobIdList) {
                String sql = String.format(
                        "INSERT INTO jobs VALUES (%d, %d);",
                        invoiceId,
                        jobId
                );
                stmt.executeUpdate(sql);
            }
            conn.commit();
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }
}

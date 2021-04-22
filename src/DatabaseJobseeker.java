import java.util.ArrayList;

/**
 * Class DatabaseJobseekerseeker.
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public class DatabaseJobseeker
{
    private static ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;

    /**
     * metode untuk mendapatkan list Jobseeker
     * @return array list Jobseeker
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase()
    {
        return JOBSEEKER_DATABASE;
    }

    /**
     * method untuk mendapatkan id terakhir
     * @return id terakhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method untuk mendapatkan list Jobseeker berdasarkan id
     * @param   id  id Jobseeker
     * @return      objek Jobseeker
     */
    public static Jobseeker getJobseekerById(int id)
    {
        Jobseeker returnValue = null;
        for(Jobseeker jobseeker: JOBSEEKER_DATABASE)
        {
            if(jobseeker.getId() == id)
            {
                returnValue = jobseeker;
            }
        }
        return returnValue;
    }

    /**
     * metode untuk menambahkan pekerjaan ke list
     * @param jobseeker objek Jobseeker
     * @return          boolean
     */
    public static boolean addJobseeker(Jobseeker jobseeker)
    {
        for(Jobseeker jobs: JOBSEEKER_DATABASE)
        {
            if(jobs.getEmail() == jobseeker.getEmail())
            {
                return false;
            }
        }
        lastId = jobseeker.getId();
        return JOBSEEKER_DATABASE.add(jobseeker);
    }

    /**
     * metode untuk menghapus pekerjaan dari list
     * @param id    id Jobseeker
     * @return      boolean
     */
    public static boolean removeJobseeker(int id)
    {
        return JOBSEEKER_DATABASE.removeIf(jobseeker -> (jobseeker.getId() == id));
    }
}
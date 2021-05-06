import java.util.ArrayList;

/**
 * Class DatabaseJob.
 *
 * @author Muhammad As'ad Muyassir
 * @version 22-04-2021
 */
public class DatabaseJob
{
    private static ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    /**
     * metode untuk mendapatkan list Job
     * @return array list Job
     */
    public static ArrayList<Job> getJobDatabase()
    {
        return JOB_DATABASE;
    }

    /**
     * metode untuk mendapatkan id terakhir
     * @return id terakhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * metode untuk mendapatkan list Job berdasarkan id
     * @param  id   id job
     * @return      objek Job
     */
    public static Job getJobById(int id) throws JobNotFoundException
    {
        Job returnValue = null;
        for(Job job: JOB_DATABASE)
        {
            if(job.getId() == id)
            {
                returnValue = job;
            }
        }
        if(returnValue == null)
        {
            throw new JobNotFoundException(id);
        }
        else
        {
            return returnValue;
        }
    }

    /**
     * metode untuk mendapatkan list Job berdasarkan recruiter
     * @param  recruiterId  id recruiter
     * @return              array list pekerjaan
     */
    public static ArrayList<Job> getJobByRecruiter(int recruiterId)
    {
        ArrayList<Job> returnValue = new ArrayList<Job>();
        for(Job job: JOB_DATABASE)
        {
            if(job.getRecruiter().getId() == recruiterId)
            {
                returnValue.add(job);
            }
        }
        return returnValue;
    }

    /**
     * metode untuk mendapatkan list Job berdasarkan kategori
     * @param  category kategori job
     * @return          array list pekerjaan
     */
    public static ArrayList<Job> getJobByCategory(JobCategory category)
    {
        ArrayList<Job> returnValue = new ArrayList<Job>();
        for(Job job: JOB_DATABASE)
        {
            if(job.getCategory() == category)
            {
                returnValue.add(job);
            }
        }
        return returnValue;
    }

    /**
     * metode untuk menambahkan pekerjaan ke list
     * @param  job  objek job
     * @return      boolean
     */
    public static boolean addJob(Job job)
    {
        lastId = job.getId();
        return JOB_DATABASE.add(job);
    }

    /**
     * metode untuk menghapus pekerjaan dari list
     * @param  id   id job
     * @return      boolean
     */
    public static boolean removeJob(int id) throws JobNotFoundException
    {
        if(JOB_DATABASE.removeIf(job -> (job.getId() == id)))
        {
            return true;
        }
        else {
            throw new JobNotFoundException(id);
        }
    }
}

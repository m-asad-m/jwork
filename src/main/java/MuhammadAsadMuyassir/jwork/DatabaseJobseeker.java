package MuhammadAsadMuyassir.jwork;

import java.util.ArrayList;

/**
 * Class Database Jobseeker.
 *
 * @author Muhammad As'ad Muyassir
 * @version 22-04-2021
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
     * @param  id                           id Jobseeker
     * @return                              objek Jobseeker
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database jobseeker
     */
    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException
    {
        for(Jobseeker jobseeker: JOBSEEKER_DATABASE)
        {
            if(jobseeker.getId() == id)
            {
                return jobseeker;
            }
        }
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * metode untuk menambahkan pekerjaan ke list
     * @param  jobseeker                    objek Jobseeker
     * @return                              boolean
     * @throws EmailAlreadyExistsException  jika email jobseeker telah terdaftar
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException
    {
        for(Jobseeker jobs: JOBSEEKER_DATABASE)
        {
            if(jobs.getEmail().equals(jobseeker.getEmail()))
            {
                throw new EmailAlreadyExistsException(jobs);
            }
        }
        lastId = jobseeker.getId();
        return JOBSEEKER_DATABASE.add(jobseeker);
    }

    /**
     * metode untuk menghapus pekerjaan dari list
     * @param  id                           id Jobseeker
     * @return                              boolean
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database jobseeker
     */
    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException
    {
        if(JOBSEEKER_DATABASE.removeIf(jobseeker -> (jobseeker.getId() == id)))
        {
            return true;
        }
        else {
            throw new JobSeekerNotFoundException(id);
        }
    }

    /**
     * metode untuk menghapus pekerjaan dari list
     * @param  email    email Jobseeker
     * @param  password password Jobseeker
     * @return          objek jobseeker
     */
    public static Jobseeker jobseekerLogin(String email, String password)
    {
        for(Jobseeker jobs: JOBSEEKER_DATABASE)
        {
            if(jobs.getEmail().equals(email) && jobs.getPassword().equals(password))
            {
                return jobs;
            }
        }
        return null;
    }
}
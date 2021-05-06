import java.util.ArrayList;

/**
 * Class DatabaseRecruiter.
 *
 * @author Muhammad As'ad Muyassir
 * @version 22-04-2021
 */
public class DatabaseRecruiter
{
    private static ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    /**
     * metode untuk mendapatkan list Recruiter
     * @return array list Recruiter
     */
    public static ArrayList<Recruiter> getRecruiterDatabase()
    {
        return RECRUITER_DATABASE;
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
     * metode untuk mendapatkan list Recruiter berdasarkan id
     * @param  id                           id recruiter
     * @return                              objek recruiter
     * @throws RecruiterNotFoundException   jika id tidak ditemukan dalam database recruiter
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException
    {
        Recruiter returnValue = null;
        for(Recruiter recruiter: RECRUITER_DATABASE)
        {
            if(recruiter.getId() == id)
            {
                returnValue = recruiter;
            }
        }
        if(returnValue == null)
        {
            throw new RecruiterNotFoundException(id);
        }
        else
        {
            return returnValue;
        }
    }

    /**
     * metode untuk menambahkan pekerjaan ke list
     * @param  recruiter    objek Recruiter
     * @return              boolean
     */
    public static boolean addRecruiter(Recruiter recruiter)
    {
        lastId = recruiter.getId();
        return RECRUITER_DATABASE.add(recruiter);
    }
    
    /**
     * metode untuk menghapus pekerjaan dari list
     * @param  id                           id recruiter
     * @return                              boolean
     * @throws RecruiterNotFoundException   jika id tidak ditemukan dalam database recruiter
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException
    {
        if(RECRUITER_DATABASE.removeIf(recruiter -> (recruiter.getId() == id)))
        {
            return true;
        }
        else {
            throw new RecruiterNotFoundException(id);
        }
    }
}
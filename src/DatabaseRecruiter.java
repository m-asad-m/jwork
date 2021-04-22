import java.util.ArrayList;

/**
 * Class DatabaseRecruiter.
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
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
     * method untuk mendapatkan id terakhir
     * @return id terakhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * method untuk mendapatkan list Recruiter berdasarkan id
     * @param   id  id recruiter
     * @return      objek recruiter
     */
    public static Recruiter getRecruiterById(int id)
    {
        Recruiter returnValue = null;
        for(Recruiter recruiter: RECRUITER_DATABASE)
        {
            if(recruiter.getId() == id)
            {
                returnValue = recruiter;
            }
        }
        return returnValue;
    }

    /**
     * metode untuk menambahkan pekerjaan ke list
     * @param recruiter objek Recruiter
     * @return          boolean
     */
    public static boolean addRecruiter(Recruiter recruiter)
    {
        lastId = recruiter.getId();
        return RECRUITER_DATABASE.add(recruiter);
    }
    
    /**
     * metode untuk menghapus pekerjaan dari list
     * @param id    id recruiter
     * @return      boolean
     */
    public static boolean removeRecruiter(int id)
    {
        return RECRUITER_DATABASE.removeIf(recruiter -> (recruiter.getId() == id));
    }
}
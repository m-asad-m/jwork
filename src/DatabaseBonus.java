import java.util.ArrayList;

/**
 * Class DatabaseBonus.
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public class DatabaseBonus
{
    private static ArrayList<Bonus> BONUS_DATABASE = new ArrayList<Bonus>();
    private static int lastId = 0;

    /**
     * metode untuk mendapatkan list Bonus
     * @return array list Bonus
     */
    public static ArrayList<Bonus> getBonusDatabase()
    {
        return BONUS_DATABASE;
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
     * method untuk mendapatkan list Bonus berdasarkan id
     * @param   id  id bonus
     * @return      objek bonus
     */
    public static Bonus getBonusById(int id)
    {
        Bonus returnValue = null;
        for(Bonus bonus: BONUS_DATABASE)
        {
            if(bonus.getId() == id)
            {
                returnValue = bonus;
            }
        }
        return returnValue;
    }

    /**
     * method for getBonusByReferralCode
     * @param referralCode  kode referral
     * @return              null
     */
    public static Bonus getBonusByReferralCode(String referralCode)
    {
        Bonus returnValue = null;
        for(Bonus bonus: BONUS_DATABASE)
        {
            if(bonus.getReferralCode() == referralCode)
            {
                returnValue = bonus;
            }
        }
        return returnValue;
    }

    /**
     * metode untuk menambahkan pekerjaan ke list
     * @param bonus objek bonus
     * @return      boolean
     */
    public static boolean addBonus(Bonus bonus)
    {
        for(Bonus b: BONUS_DATABASE)
        {
            if(b.getReferralCode() == bonus.getReferralCode())
            {
                return false;
            }
        }
        lastId = bonus.getId();
        return BONUS_DATABASE.add(bonus);
    }

    /**
     * method for activeBonus
     * @param id    id bonus
     * @return      false
     */
    public static boolean activateBonus(int id)
    {
        for(Bonus bonus: BONUS_DATABASE)
        {
            if(bonus.getId() == id)
            {
                bonus.setActive(true);
                return true;
            }
        }
        return false;
    }
    /**
     * method for deactivateBonus
     * @param id    id bonus
     * @return      false
     */
    public static boolean deactivateBonus(int id)
    {
        for(Bonus bonus: BONUS_DATABASE)
        {
            if(bonus.getId() == id)
            {
                bonus.setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * metode untuk menghapus pekerjaan dari list
     * @param id    id Bonus
     * @return      boolean
     */
    public static boolean removeBonus(int id)
    {
        return BONUS_DATABASE.removeIf(bonus -> (bonus.getId() == id));
    }
}

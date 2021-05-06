import java.util.ArrayList;

/**
 * Class DatabaseBonus.
 *
 * @author Muhammad As'ad Muyassir
 * @version 22-04-2021
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
     * metode untuk mendapatkan id terakhir
     * @return id terakhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * metode untuk mendapatkan list Bonus berdasarkan id
     * @param   id  id bonus
     * @return      objek bonus
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException
    {
        Bonus returnValue = null;
        for(Bonus bonus: BONUS_DATABASE)
        {
            if(bonus.getId() == id)
            {
                returnValue = bonus;
            }
        }
        if(returnValue == null)
        {
            throw new BonusNotFoundException(id);
        }
        else
        {
            return returnValue;
        }
    }

    /**
     * metode for getBonusByReferralCode
     * @param  referralCode kode referral
     * @return              objek bonus
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
     * @param  bonus    objek bonus
     * @return          boolean
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException
    {
        for(Bonus b: BONUS_DATABASE)
        {
            if(b.getReferralCode() == bonus.getReferralCode())
            {
                throw new ReferralCodeAlreadyExistsException(b);
            }
        }
        lastId = bonus.getId();
        return BONUS_DATABASE.add(bonus);
    }

    /**
     * metode untuk mengaktifkan bonus
     * @param  id   id bonus
     * @return      boolean
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
     * metode untuk menonaktifkan bonus
     * @param  id   id bonus
     * @return      boolean
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
     * @param  id   id Bonus
     * @return      boolean
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException
    {
        if(BONUS_DATABASE.removeIf(bonus -> (bonus.getId() == id)))
        {
            return true;
        }
        else {
            throw new BonusNotFoundException(id);
        }
    }
}

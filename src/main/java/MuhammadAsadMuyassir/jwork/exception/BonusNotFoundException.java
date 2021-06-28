package MuhammadAsadMuyassir.jwork.exception;

/**
 * Class BonusNotFoundException adalah class yang melakukan penanganan
 * jika bonus tidak ditemukan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class BonusNotFoundException extends Exception {
    private String bonus_error;

    /**
     * Constructor untuk objek dari class BonusNotFoundException
     * @param id id bonus
     */
    public BonusNotFoundException(int id)
    {
        super("Bonus ID: ");
        bonus_error = String.valueOf(id);
    }

    /**
     * Constructor untuk objek dari class BonusNotFoundException
     * @param referralCode kode referral bonus
     */
    public BonusNotFoundException(String referralCode)
    {
        super("Bonus Referral Code: ");
        bonus_error = referralCode;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + bonus_error + " not found";
    }
}

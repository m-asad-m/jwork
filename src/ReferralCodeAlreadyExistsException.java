/**
 * Class ReferralCodeAlreadyExistsException adalah class yang melakukan penanganan kesalahan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class ReferralCodeAlreadyExistsException extends Exception {
    private Bonus referral_error;

    /**
     * Constructor untuk objek dari class ReferralCodeAlreadyExistsException
     * @param referral_input objek bonus
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input)
    {
        super("Referral Code: ");
        referral_error = referral_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}

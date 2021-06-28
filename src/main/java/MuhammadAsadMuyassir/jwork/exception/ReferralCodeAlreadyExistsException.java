package MuhammadAsadMuyassir.jwork.exception;

import MuhammadAsadMuyassir.jwork.object.Bonus;

/**
 * Class ReferralCodeAlreadyExistsException adalah class yang melakukan penanganan
 * jika kode referral sudah terdaftar
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class ReferralCodeAlreadyExistsException extends Exception {
    private String referral_error;

    /**
     * Constructor untuk objek dari class ReferralCodeAlreadyExistsException
     * @param referral_input objek bonus
     */
    public ReferralCodeAlreadyExistsException(Bonus referral_input)
    {
        super("Referral Code: ");
        referral_error = referral_input.getReferralCode();
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + referral_error + " already exists.";
    }
}

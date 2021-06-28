package MuhammadAsadMuyassir.jwork.exception;

import MuhammadAsadMuyassir.jwork.object.Recruiter;

/**
 * Class PhoneNumberAlreadyExistsException adalah class yang melakukan penanganan
 * jika nomor telepon sudah terdaftar
 *
 * @author Muhammad As'ad Muyassir
 * @version 20-06-2021
 */

public class PhoneNumberAlreadyExistsException extends Exception {
    private String phone_number_error;

    /**
     * Constructor untuk objek dari class PhoneNumberAlreadyExistsException
     * @param recruiter_input objek recruiter
     */
    public PhoneNumberAlreadyExistsException(Recruiter recruiter_input)
    {
        super("Recruiter Phone Number: ");
        phone_number_error = recruiter_input.getPhoneNumber();
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + phone_number_error + " already exists.";
    }
}

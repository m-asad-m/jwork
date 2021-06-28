package MuhammadAsadMuyassir.jwork.exception;

import MuhammadAsadMuyassir.jwork.object.Jobseeker;
import MuhammadAsadMuyassir.jwork.object.Recruiter;

/**
 * Class EmailAlreadyExistsException adalah class yang melakukan penanganan
 * jika email sudah terdaftar
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class EmailAlreadyExistsException extends Exception {
    private String email_error;

    /**
     * Constructor untuk objek dari class EmailAlreadyExistsException
     * @param jobseeker_input objek pencari pekerjaan
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input)
    {
        super("Jobseeker Email: ");
        email_error = jobseeker_input.getEmail();
    }

    /**
     * Constructor untuk objek dari class EmailAlreadyExistsException
     * @param recruiter_input objek perekrut
     */
    public EmailAlreadyExistsException(Recruiter recruiter_input)
    {
        super("Recruiter Email: ");
        email_error = recruiter_input.getEmail();
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + email_error + " already exists.";
    }
}

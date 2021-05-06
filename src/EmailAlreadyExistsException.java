/**
 * Class EmailAlreadyExistsException adalah class yang melakukan penanganan kesalahan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class EmailAlreadyExistsException extends Exception {
    private Jobseeker jobseeker_error;

    /**
     * Constructor untuk objek dari class EmailAlreadyExistsException
     * @param jobseeker_input objek pencari pekerjaan
     */
    public EmailAlreadyExistsException(Jobseeker jobseeker_input)
    {
        super("Jobseeker Email: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + jobseeker_error.getEmail() + " already exists.";
    }
}

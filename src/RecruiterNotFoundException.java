/**
 * Class RecruiterNotFoundException adalah class yang melakukan penanganan kesalahan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class RecruiterNotFoundException extends Exception {
    private int recruiter_error;

    /**
     * Constructor untuk objek dari class RecruiterNotFoundException
     * @param recruiter_input id perekrut
     */
    public RecruiterNotFoundException(int recruiter_input)
    {
        super("Recruiter ID: ");
        recruiter_error = recruiter_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + recruiter_error + " not found";
    }
}

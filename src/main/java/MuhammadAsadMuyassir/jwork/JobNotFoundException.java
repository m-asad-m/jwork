package MuhammadAsadMuyassir.jwork;

/**
 * Class JobNotFoundException adalah class yang melakukan penanganan kesalahan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class JobNotFoundException extends Exception {
    private int job_error;

    /**
     * Constructor untuk objek dari class JobNotFoundException
     * @param job_input pencari pekerjaan
     */
    public JobNotFoundException(int job_input)
    {
        super("Job ID: ");
        job_error = job_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + job_error + " not found";
    }
}

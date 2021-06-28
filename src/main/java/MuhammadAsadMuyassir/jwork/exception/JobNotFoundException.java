package MuhammadAsadMuyassir.jwork.exception;

/**
 * Class JobNotFoundException adalah class yang melakukan
 * penanganan jika pekerjaan tidak ditemukan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class JobNotFoundException extends Exception {
    private int job_error;

    /**
     * Constructor untuk objek dari class JobNotFoundException
     * @param job_input id pekerjaan
     */
    public JobNotFoundException(int job_input)
    {
        super("Job ID: ");
        job_error = job_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + job_error + " not found";
    }
}

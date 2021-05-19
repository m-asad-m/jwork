package MuhammadAsadMuyassir.jwork;

/**
 * Class JobSeekerNotFoundException adalah class yang melakukan penanganan kesalahan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class JobSeekerNotFoundException extends Exception {
    private int jobseeker_error;

    /**
     * Constructor untuk objek dari class JobSeekerNotFoundException
     * @param jobseeker_input id pencari pekerjaan
     */
    public JobSeekerNotFoundException(int jobseeker_input)
    {
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + jobseeker_error + " not found";
    }
}

package MuhammadAsadMuyassir.jwork.exception;

/**
 * Class JobSeekerNotFoundException adalah class yang melakukan penanganan
 * jika pencari pekerjaan tidak ditemukan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class JobSeekerNotFoundException extends Exception {
    private String jobseeker_error;

    /**
     * Constructor untuk objek dari class JobSeekerNotFoundException
     * @param id id pencari pekerjaan
     */
    public JobSeekerNotFoundException(int id)
    {
        super("Jobseeker ID: ");
        jobseeker_error = String.valueOf(id);
    }

    /**
     * Constructor untuk objek dari class JobSeekerNotFoundException
     * @param email email pencari pekerjaan
     */
    public JobSeekerNotFoundException(String email)
    {
        super("Jobseeker Email or Password: ");
        jobseeker_error = email;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + jobseeker_error + " not found";
    }
}

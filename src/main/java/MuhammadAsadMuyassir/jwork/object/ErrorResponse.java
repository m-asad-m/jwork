package MuhammadAsadMuyassir.jwork.object;

import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Class ErrorResponse adalah class yang digunakan untuk membuat response error
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class ErrorResponse {
    private final Date timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    /**
     * Constructor untuk objek dari class ErrorResponse
     *
     * @param req       objek http request
     * @param status    objek http status
     * @param message   string pesan
     */
    public ErrorResponse(HttpServletRequest req, HttpStatus status, String message)
    {
        this.timestamp = new Date();
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.message = message;
        this.path = req.getRequestURI();
    }

    /**
     * Metode untuk mendapatkan timestamp
     *
     * @return objek date timestamp
     */
    public Date getTimestamp()
    {
        return timestamp;
    }

    /**
     * Metode untuk mendapatkan status
     *
     * @return integer status
     */
    public int getStatus()
    {
        return status;
    }

    /**
     * Metode untuk mendapatkan kode error
     *
     * @return string kode error
     */
    public String getError()
    {
        return error;
    }

    /**
     * Metode untuk mendapatkan pesan error
     *
     * @return string pesan error
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Metode untuk mendapatkan path alamat
     *
     * @return string path alamat
     */
    public String getPath()
    {
        return path;
    }
}

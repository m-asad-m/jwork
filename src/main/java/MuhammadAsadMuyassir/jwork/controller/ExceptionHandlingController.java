package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.object.ErrorResponse;
import MuhammadAsadMuyassir.jwork.exception.*;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Class ExceptionHandlingController adalah class yang menghandle seluruh exception
 * untuk dapat dikembalikan dalam bentuk http response yang sesuai
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
@ControllerAdvice
public class ExceptionHandlingController {

    /**
     * Metode untuk menghandle seluruh error already exists
     *
     * @param req   objek http request
     * @param e     objek exception
     * @return      objek http response
     */
    @ExceptionHandler({
            EmailAlreadyExistsException.class,
            PhoneNumberAlreadyExistsException.class,
            ReferralCodeAlreadyExistsException.class,
            OngoingInvoiceAlreadyExistsException.class
    })
    public ResponseEntity<ErrorResponse> conflictHandling(HttpServletRequest req, Exception e) {
        System.out.println(e.getMessage());
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse apiError = new ErrorResponse(req, status, e.getLocalizedMessage());
        return ResponseEntity.status(status).body(apiError);
    }

    /**
     * Metode untuk menghandle seluruh error not found
     *
     * @param req   objek http request
     * @param e     objek exception
     * @return      objek http response
     */
    @ExceptionHandler({
            JobSeekerNotFoundException.class,
            RecruiterNotFoundException.class,
            JobNotFoundException.class,
            BonusNotFoundException.class,
            InvoiceNotFoundException.class,
            IOException.class
    })
    public ResponseEntity<ErrorResponse> notFoundHandling(HttpServletRequest req, Exception e) {
        System.out.println(e.getMessage());
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse apiError = new ErrorResponse(req, status, e.getLocalizedMessage());
        return ResponseEntity.status(status).body(apiError);
    }
}

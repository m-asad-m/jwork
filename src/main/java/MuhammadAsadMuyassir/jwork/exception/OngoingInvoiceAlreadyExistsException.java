package MuhammadAsadMuyassir.jwork.exception;

import MuhammadAsadMuyassir.jwork.object.Invoice;

/**
 * Class OngoingInvoiceAlreadyExistsException adalah class yang melakukan penanganan
 * jika sudah terdapat invoice yang berstatus OnGoing
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private int invoice_error;

    /**
     * Constructor untuk objek dari class OngoingInvoiceAlreadyExistsException
     * @param invoice_input objek invoice
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Ongoing Invoice with Job Seeker Id: ");
        invoice_error = invoice_input.getJobseeker().getId();
    }

    /**
     * Constructor untuk objek dari class OngoingInvoiceAlreadyExistsException
     * @param jobseeker_id_input id jobseeker
     */
    public OngoingInvoiceAlreadyExistsException(int jobseeker_id_input)
    {
        super("Ongoing Invoice with Job Seeker Id: ");
        invoice_error = jobseeker_id_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error + " already exists.";
    }
}

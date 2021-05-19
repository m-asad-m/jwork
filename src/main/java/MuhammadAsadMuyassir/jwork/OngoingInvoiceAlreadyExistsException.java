package MuhammadAsadMuyassir.jwork;

/**
 * Class OngoingInvoiceAlreadyExistsException adalah class yang melakukan penanganan kesalahan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class OngoingInvoiceAlreadyExistsException extends Exception {
    private Invoice invoice_error;

    /**
     * Constructor untuk objek dari class OngoingInvoiceAlreadyExistsException
     * @param invoice_input objek invoice
     */
    public OngoingInvoiceAlreadyExistsException(Invoice invoice_input)
    {
        super("Ongoing Invoice: ");
        invoice_error = invoice_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error.getId() + " already exists.";
    }
}

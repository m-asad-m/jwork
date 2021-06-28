package MuhammadAsadMuyassir.jwork.exception;

/**
 * Class InvoiceNotFoundException adalah class yang melakukan penanganan
 * jika invoice tidak ditemukan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class InvoiceNotFoundException extends Exception {
    private int invoice_error;

    /**
     * Constructor untuk objek dari class InvoiceNotFoundException
     * @param invoice_input id Invoice
     */
    public InvoiceNotFoundException(int invoice_input)
    {
        super("Invoice ID: ");
        invoice_error = invoice_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return string pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + invoice_error + " not found";
    }
}

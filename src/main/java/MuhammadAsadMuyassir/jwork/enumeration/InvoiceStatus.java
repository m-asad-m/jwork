package MuhammadAsadMuyassir.jwork.enumeration;

/**
 * Enumeration InvoiceStatus adalah class yang digunakan sebagai enumerasi status invoice
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public enum InvoiceStatus
{
    OnGoing,
    Finished,
    Cancelled;

    /**
     * Metode untuk mendapatkan enum dalam bentuk string
     * @return  string dari enum
     */
    public String toString()
    {
        switch (this)
        {
            case OnGoing:
                return "Ongoing";
            case Finished:
                return "Finished";
            case Cancelled:
                return "Cancelled";
            default:
                return "Wrong Status Type";
        }
    }
}

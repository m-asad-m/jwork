
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-03-2021
 */
public enum InvoiceStatus
{
    OnGoing,
    Finished,
    Cancelled;
    
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

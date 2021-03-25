/**
 * Enumeration class PaymentType
 *
 * @author Muhammad As'ad Muyassir
 * @version 25-03-2021
 */
public enum PaymentType
{
    BankPayment,
    EwalletPayment;
    
    public String toString()
    {
        switch (this)
        {
            case BankPayment:
                return "Bank Payment";
            case EwalletPayment:
                return "Ewallet Payment";
            default:
                return "Wrong Payment Type";
        }
    }
}
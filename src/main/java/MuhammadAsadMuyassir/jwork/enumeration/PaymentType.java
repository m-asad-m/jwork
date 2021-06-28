package MuhammadAsadMuyassir.jwork.enumeration;

/**
 * Enumeration PaymentType adalah class yang digunakan sebagai enumerasi tipe pembayaran
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public enum PaymentType
{
    BankPayment,
    EwalletPayment;

    /**
     * Metode untuk mendapatkan enum dalam bentuk string
     * @return  string dari enum
     */
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
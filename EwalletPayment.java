/**
 * Class Job adalah class yang menyimpan data pekerjaan.
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public class EwalletPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor untuk objek dari class Invoice
     * @param id            id invoice
     * @param job           objek pekerjaan
     * @param date          tanggal invoice dibuat
     * @param jobseeker     objek pekerja
     * @param paymentType   objek tipe pembayaran
     * @param invoiceStatus objek status invoice
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
    }
    
    /**
     * Constructor untuk objek dari class Invoice
     * @param id            id invoice
     * @param job           objek pekerjaan
     * @param date          tanggal invoice dibuat
     * @param jobseeker     objek pekerja
     * @param paymentType   objek tipe pembayaran
     * @param bonus         objek bonus
     * @param invoiceStatus objek status invoice
     */
    public EwalletPayment(int id, Job job, String date, Jobseeker jobseeker, Bonus bonus, InvoiceStatus invoiceStatus)
    {
        super(id, job, date, jobseeker, invoiceStatus);
        this.bonus = bonus;
    }
    
    /**
     * metode untuk mendapatkan data tipe pembayaran
     * @return enum tipe pembayaran
     */
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * metode untuk mendapatkan data bonus
     * @return objek bonus
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    
    /**
     * metode untuk mengubah data bonus
     * @param bonus objek bonus
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
    }
    
    /**
     * metode untuk mengubah total bayaran
     * @param totalFee total bayaran
     */
    @Override
    public void setTotalFee()
    {
        if(bonus instanceof Bonus && bonus.getActive() && totalFee > bonus.getMinTotalFee())
        {
            super.totalFee = super.getJob().getFee() + bonus.getExtraFee();
        }
        else
        {
            totalFee = getJob().getFee();
        }
    }
    
    /** metode untuk melakukan print data pada terminal */
    @Override
    public void printData()
    {
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + getId());
        System.out.println("Job: " + getJob().getName());
        System.out.println("Date: " + getDate());
        System.out.println("Job Seeker: " + getJobseeker().getName());
        if(bonus instanceof Bonus && bonus.getActive() && totalFee > bonus.getMinTotalFee())
        {
            System.out.println("Referral Code: " + bonus.getReferralCode());
        }
        System.out.println("Total Fee: " + totalFee);
        System.out.println("Status: " + getInvoiceStatus().toString());
        System.out.println("Payment Type: " + PAYMENT_TYPE);
    }
}

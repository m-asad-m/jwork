import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
     * @param jobseeker     objek pekerja
     * @param paymentType   objek tipe pembayaran
     * @param invoiceStatus objek status invoice
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    /**
     * Constructor untuk objek dari class Invoice
     * @param id            id invoice
     * @param job           objek pekerjaan
     * @param jobseeker     objek pekerja
     * @param paymentType   objek tipe pembayaran
     * @param bonus         objek bonus
     * @param invoiceStatus objek status invoice
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus)
    {
        super(id, jobs, jobseeker);
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
        int total = 0;
        for(Job job: getJobs())
        {
            total += job.getFee();
        }
        if(bonus instanceof Bonus && bonus.getActive() && total > bonus.getMinTotalFee())
        {

            totalFee = total + bonus.getExtraFee();
        }
        else
        {
            totalFee = total;
        }
    }
    
    /** metode untuk melakukan print data pada terminal */
    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String returnValue = "===================== INVOICE =====================" + "\n" +
                             "ID: " + getId() + "\n" +
                             "Jobs: ";
        for(Job job: getJobs()) {
            returnValue += job.getName() + " ";
        }
        returnValue += "Date: " + sdf.format(getDate().getTime()) + "\n" +
                       "Job Seeker: " + getJobseeker().getName() + "\n";
        if(bonus instanceof Bonus && bonus.getActive() && getTotalFee() > bonus.getMinTotalFee())
        {
            returnValue += "Referral Code: " + bonus.getReferralCode() + "\n" ;
        }
        returnValue += "Total Fee: " + totalFee + "\n" +
                       "Status: " + getInvoiceStatus().toString() + "\n" +
                       "Payment Type: " + PAYMENT_TYPE;
        return returnValue;
    }
}
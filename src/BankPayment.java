import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Class Job adalah class yang menyimpan data pekerjaan.
 *
 * @author Muhammad As'ad Muyassir
 * @version 03-04-2021
 */
public class BankPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;

    /**
     * Constructor untuk objek dari class Invoice
     * @param id            id invoice
     * @param job           objek pekerjaan
     * @param jobseeker     objek pekerja
     * @param paymentType   objek tipe pembayaran
     * @param invoiceStatus objek status invoice
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    /**
     * Constructor untuk objek dari class Invoice
     * @param id            id invoice
     * @param job           objek pekerjaan
     * @param jobseeker     objek pekerja
     * @param paymentType   objek tipe pembayaran
     * @param adminFee      objek adminFee
     * @param invoiceStatus objek status invoice
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee)
    {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
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
     * metode untuk mendapatkan data adminFee
     * @return objek adminFee
     */
    public int getAdminFee()
    {
        return adminFee;
    }
    
    /**
     * metode untuk mengubah data adminFee
     * @param adminFee objek adminFee
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }
    
    /**
     * metode untuk mengubah total bayaran
     * @param totalFee total bayaran
     */
    @Override
    public void setTotalFee()
    {
        if(adminFee != 0)
        {
            totalFee = 0;
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
            totalFee -= adminFee;
        }
        else
        {
            totalFee = 0;
            for(Job job: getJobs())
            {
                totalFee += job.getFee();
            }
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
        returnValue += "\n" + "Date: " + sdf.format(getDate().getTime()) + "\n" +
                             "Job Seeker: " + getJobseeker().getName() + "\n" +
                             "Admin Fee: " + adminFee + "\n" +
                             "Total Fee: " + totalFee + "\n" +
                             "Status: " + getInvoiceStatus().toString() + "\n" +
                             "Payment Type: " + PAYMENT_TYPE;
        return returnValue;
    }
}
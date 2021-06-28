package MuhammadAsadMuyassir.jwork.object;

import MuhammadAsadMuyassir.jwork.enumeration.PaymentType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class Bank Payment adalah class yang menyimpan data invoice
 * yang menggunakan tipe pembayaran bank
 *
 * @author Muhammad As'ad Muyassir
 * @version 22-04-2021
 * @see Invoice
 */
public class BankPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.BankPayment;
    private int adminFee;

    /**
     * Constructor untuk objek dari class BankPayment
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    /**
     * Constructor untuk objek dari class BankPayment
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     * @param adminFee      objek adminFee
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee)
    {
        super(id, jobs, jobseeker);
        this.adminFee = adminFee;
    }

    /**
     * Constructor untuk objek dari class BankPayment
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     * @param date          objek kalender
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Calendar date)
    {
        super(id, jobs, jobseeker, date);
    }

    /**
     * Constructor untuk objek dari class BankPayment
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     * @param adminFee      objek adminFee
     * @param date          objek kalender
     */
    public BankPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, int adminFee, Calendar date)
    {
        super(id, jobs, jobseeker, date);
        this.adminFee = adminFee;
    }
    
    /**
     * Metode untuk mendapatkan data tipe pembayaran
     *
     * @return enum tipe pembayaran
     */
    @Override
    public PaymentType getPaymentType()
    {
        return PAYMENT_TYPE;
    }
    
    /**
     * Metode untuk mendapatkan data adminFee
     *
     * @return objek adminFee
     */
    public int getAdminFee()
    {
        return adminFee;
    }
    
    /**
     * Metode untuk mengubah data adminFee
     *
     * @param adminFee objek adminFee
     */
    public void setAdminFee(int adminFee)
    {
        this.adminFee = adminFee;
    }

    /**
     * Metode untuk mengubah total bayaran
     *
     * @param totalFee total bayaran
     */
    @Override
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }

    /**
     * Metode untuk menghitung total bayaran
     */
    @Override
    public void calculateTotalFee()
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
    
    /** Metode untuk mendapatkan objek Invoice dalam bentuk string */
    @Override
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String returnValue = "===================== INVOICE =====================" + "\n" +
                             "ID: " + getId() + "\n" +
                             "Jobs: ";
        for(int i = 0; i < getJobs().size(); i++){
            returnValue += getJobs().get(i).getName();
            if(i < getJobs().size()-1){
                returnValue +=  ", ";
            }
            else {
                returnValue += "\n";
            }
        }
        returnValue += "Date: " + sdf.format(getDate().getTime()) + "\n" +
                       "Job Seeker: " + getJobseeker().getName() + "\n" +
                       "Admin Fee: " + adminFee + "\n" +
                       "Total Fee: " + totalFee + "\n" +
                       "Status: " + getInvoiceStatus().toString() + "\n" +
                       "Payment Type: " + PAYMENT_TYPE + "\n";
        return returnValue;
    }
}
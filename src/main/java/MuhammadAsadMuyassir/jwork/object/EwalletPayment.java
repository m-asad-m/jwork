package MuhammadAsadMuyassir.jwork.object;

import MuhammadAsadMuyassir.jwork.enumeration.PaymentType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class Ewallet Payment adalah class yang menyimpan data invoice
 * yang menggunakan tipe pembayaran E-Wallet
 *
 * @author Muhammad As'ad Muyassir
 * @version 22-04-2021
 * @see Invoice
 */
public class EwalletPayment extends Invoice
{
    private final static PaymentType PAYMENT_TYPE = PaymentType.EwalletPayment;
    private Bonus bonus;

    /**
     * Constructor untuk objek dari class Ewallet
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        super(id, jobs, jobseeker);
    }
    
    /**
     * Constructor untuk objek dari class Ewallet
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     * @param bonus         objek bonus
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus)
    {
        super(id, jobs, jobseeker);
        this.bonus = bonus;
    }

    /**
     * Constructor untuk objek dari class Ewallet
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     * @param date          objek kalender
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Calendar date)
    {
        super(id, jobs, jobseeker, date);
    }

    /**
     * Constructor untuk objek dari class Ewallet
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     * @param bonus         objek bonus
     * @param date          objek kalender
     */
    public EwalletPayment(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Bonus bonus, Calendar date)
    {
        super(id, jobs, jobseeker, date);
        this.bonus = bonus;
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
     * Metode untuk mendapatkan data bonus
     *
     * @return objek bonus
     */
    public Bonus getBonus()
    {
        return bonus;
    }
    
    /**
     * Metode untuk mengubah data bonus
     *
     * @param bonus objek bonus
     */
    public void setBonus(Bonus bonus)
    {
        this.bonus = bonus;
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
                       "Job Seeker: " + getJobseeker().getName() + "\n";
        if(bonus instanceof Bonus && bonus.getActive() && getTotalFee() > bonus.getMinTotalFee())
        {
            returnValue += "Referral Code: " + bonus.getReferralCode() + "\n" ;
        }
        returnValue += "Total Fee: " + totalFee + "\n" +
                       "Status: " + getInvoiceStatus().toString() + "\n" +
                       "Payment Type: " + PAYMENT_TYPE + "\n";
        return returnValue;
    }
}
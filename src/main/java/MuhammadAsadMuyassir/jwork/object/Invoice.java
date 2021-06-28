package MuhammadAsadMuyassir.jwork.object;

import MuhammadAsadMuyassir.jwork.enumeration.InvoiceStatus;
import MuhammadAsadMuyassir.jwork.enumeration.PaymentType;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class Invoice adalah class yang menyimpan data invoice
 *
 * @author Muhammad As'ad Muyassir
 * @version 24-04-2021
 */
public abstract class Invoice
{
    private int id;
    private ArrayList<Job> jobs;
    private Calendar date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor untuk objek dari class Invoice
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker)
    {
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        date = Calendar.getInstance();
    }

    /**
     * Constructor untuk objek dari class Invoice
     *
     * @param id            id invoice
     * @param jobs          array list pekerjaan
     * @param jobseeker     objek pekerja
     * @param date          objek kalender
     */
    public Invoice(int id, ArrayList<Job> jobs, Jobseeker jobseeker, Calendar date)
    {
        this.id = id;
        this.jobs = jobs;
        this.jobseeker = jobseeker;
        this.invoiceStatus = InvoiceStatus.OnGoing;
        this.date = date;
    }
    
    /**
     * Metode untuk mendapatkan id invoice
     *
     * @return id invoice
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Metode untuk mendapatkan id pekerjaan
     *
     * @return id pekerjaan
     */
    public ArrayList<Job> getJobs()
    {
        return jobs;
    }
    
    /**
     * Metode untuk mendapatkan tanggal dibuat invoice
     *
     * @return tanggal invoice dibuat
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * Metode untuk mendapatkan total bayaran
     *
     * @return total bayaran
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
    /**
     * Metode untuk mendapatkan data pekerja
     *
     * @return objek pekerja
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
    
    /**
     * Metode untuk mendapatkan data tipe pembayaran
     *
     * @return objek tipe pembayaran
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * Metode untuk mendapatkan data status invoice
     *
     * @return objek status invoice
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    
    /**
     * Metode untuk mengubah id invoice
     *
     * @param id id invoice
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Metode untuk mengubah id pekerjaan
     *
     * @param jobs array list pekerjaan
     */
    public void setJobs(ArrayList<Job> jobs)
    {
        this.jobs = jobs;
    }
    
    /**
     * Metode untuk mengubah tanggal invoice
     *
     * @param date objek gregorian calendar tanggal invoice
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
    /**
     * Metode untuk mengubah tanggal invoice
     *
     * @param year       tahun invoice
     * @param month      bulan invoice
     * @param dayOfMonth tanggal invoice
     */
    public void setDate(int year, int month, int dayOfMonth)
    {
        date.set(year, month-1, dayOfMonth);
    }
    
    /**
     * Metode untuk mengubah total bayaran
     *
     * @param totalFee total bayaran
     */
    public abstract void setTotalFee(int totalFee);
    
    /**
     * Metode untuk mengubah data pekerja
     *
     * @param jobseeker objek pekerja
     */
    public void setJobseeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**
     * Metode untuk mengubah data status invoice
     *
     * @param invoiceStatus objek status invoice
     */
    public void setInvoiceStatus(InvoiceStatus invoiceStatus)
    {
        this.invoiceStatus = invoiceStatus;
    }

    /**
     * Metode untuk menghitung total bayaran
     */
    public abstract void calculateTotalFee();
    
    /** Metode untuk mendapatkan objek Invoice dalam bentuk string */
    public abstract String toString();
}

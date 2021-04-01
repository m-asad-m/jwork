/**
 * Class Invoice adalah class yang menyimpan data invoice.
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public abstract class Invoice
{
    private int id;
    private Job job;
    private String date;
    protected int totalFee;
    private Jobseeker jobseeker;
    private InvoiceStatus invoiceStatus;

    /**
     * Constructor untuk objek dari class Invoice
     * @param id            id invoice
     * @param job           objek pekerjaan
     * @param date          tanggal invoice dibuat
     * @param jobseeker     objek pekerja
     * @param paymentType   objek tipe pembayaran
     * @param invoiceStatus objek status invoice
     */
    public Invoice(int id, Job job, String date, Jobseeker jobseeker, InvoiceStatus invoiceStatus)
    {
        this.id = id;
        this.job = job;
        this.date = date;
        this.jobseeker = jobseeker;
        this.invoiceStatus = invoiceStatus;
    }
    
    /**
     * metode untuk mendapatkan id invoice
     * @return id invoice
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * metode untuk mendapatkan id pekerjaan
     * @return id pekerjaan
     */
    public Job getJob()
    {
        return job;
    }
    
    /**
     * metode untuk mendapatkan tanggal dibuat invoice
     * @return tanggal invoice dibuat
     */
    public String getDate()
    {
        return date;
    }
    
    /**
     * metode untuk mendapatkan total bayaran
     * @return total bayaran
     */
    public int getTotalFee()
    {
        return totalFee;
    }
    
    /**
     * metode untuk mendapatkan data pekerja
     * @return objek pekerja
     */
    public Jobseeker getJobseeker()
    {
        return jobseeker;
    }
    
    /**
     * metode untuk mendapatkan data tipe pembayaran
     * @return objek tipe pembayaran
     */
    public abstract PaymentType getPaymentType();
    
    /**
     * metode untuk mendapatkan data status invoice
     * @return objek status invoice
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return invoiceStatus;
    }
    
    /**
     * metode untuk mengubah id invoice
     * @param id id invoice
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * metode untuk mengubah id pekerjaan
     * @param id id pekerjaan
     */
    public void setJob(Job job)
    {
        this.job = job;
    }
    
    /**
     * metode untuk mengubah tanggal invoice
     * @param date tanggal invoice
     */
    public void setDate(String date)
    {
        this.date = date;
    }
    
    /**
     * metode untuk mengubah total bayaran
     * @param totalFee total bayaran
     */
    public abstract void setTotalFee();
    
    /**
     * metode untuk mengubah data pekerja
     * @param jobseeker objek pekerja
     */
    public void setJobseeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**
     * metode untuk mengubah data status invoice
     * @param status objek status invoice
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.invoiceStatus = invoiceStatus;
    }
    
    /** metode untuk melakukan print data pada terminal */
    public abstract void printData();
}

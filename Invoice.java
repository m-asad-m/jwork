/**
 * Class Invoice adalah class yang menyimpan data invoice.
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-03-2021
 */
public class Invoice
{
    private int id, idJob, totalFee, totalPrice;
    private String date;
    Jobseeker jobseeker;
    PaymentType paymentType;
    InvoiceStatus status;

    /**
     * Constructor untuk objek dari class Invoice
     * @param id          id invoice
     * @param idJob       id pekerjaan
     * @param date        tanggal invoice dibuat
     * @param totalFee    total bayaran pada invoice
     * @param jobseeker   objek pekerja
     * @param paymentType objek tipe pembayaran
     * @param status      objek status invoice
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker, PaymentType paymentType, InvoiceStatus status)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.paymentType = paymentType;
        this.jobseeker = jobseeker;
        this.status = status;
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
    public int getIdJob()
    {
        return idJob;
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
    public PaymentType getPaymentType()
    {
        return paymentType;
    }
    
    /**
     * metode untuk mendapatkan data status invoice
     * @return objek status invoice
     */
    public InvoiceStatus getInvoiceStatus()
    {
        return status;
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
    public void setIdJob(int idJob)
    {
        this.idJob = idJob;
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
    public void setTotalFee(int totalFee)
    {
        this.totalFee = totalFee;
    }
    
    /**
     * metode untuk mengubah data pekerja
     * @param jobseeker objek pekerja
     */
    public void setJobseeker(Jobseeker jobseeker)
    {
        this.jobseeker = jobseeker;
    }
    
    /**
     * metode untuk mengubah data tipe pembayaran
     * @param paymentType objek tipe pembayaran
     */
    public void setJobseeker(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }
    
    /**
     * metode untuk mengubah data status invoice
     * @param status objek status invoice
     */
    public void setInvoiceStatus(InvoiceStatus status)
    {
        this.status = status;
    }
    
    /** metode untuk melakukan print data pada terminal */
    public void printData()
    {
        System.out.println("===================== INVOICE =====================");
        System.out.println("ID: " + id);
        System.out.println("ID Job: " + idJob);
        System.out.println("Date: " + date);
        System.out.println("Seeker: " + jobseeker.getName());
        System.out.println("Fee: " + totalFee);
        System.out.println("Status: " + status.toString());
    }
}

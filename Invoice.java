/**
 * Class Invoice adalah class yang menyimpan data invoice.
 *
 * @author Muhammad As'ad Muyassir
 * @version 18-03-2021
 */
public class Invoice
{
    private int id, idJob, totalFee;
    private String date;
    Jobseeker jobseeker;

    /**
     * Constructor untuk objek dari class Invoice
     * @param id        id invoice
     * @param idJob     id pekerjaan
     * @param date      tanggal invoice dibuat
     * @param totalFee  total bayaran pada invoice
     * @param jobseeker objek pekerja
     */
    public Invoice(int id, int idJob, String date, int totalFee, Jobseeker jobseeker)
    {
        this.id = id;
        this.idJob = idJob;
        this.date = date;
        this.totalFee = totalFee;
        this.jobseeker = jobseeker;
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
    
    /** metode untuk melakukan print data pada terminal */
    public void printData()
    {
        System.out.println(totalFee);
    }
}

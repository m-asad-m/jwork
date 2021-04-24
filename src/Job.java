/**
 * Class Job adalah class yang menyimpan data pekerjaan.
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public class Job
{
    private int id, fee;
    private String name;
    private JobCategory category;
    private Recruiter recruiter;

    /**
     * Constructor untuk objek dari class Job
     * @param id        id pekerjaan
     * @param name      nama pekerjaan
     * @param recruiter objek pemilik pekerjaan(Recruiter)
     * @param fee       bayaran pekerjaan
     * @param category  kategori pekerjaan
     */
    public Job(int id, String name, Recruiter recruiter, int fee, JobCategory category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
    }
    
    /**
     * metode untuk mendapatkan id dari pekerjaan
     * @return id pekerjaan
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * metode untuk mendapatkan nama dari pekerjaan
     * @return nama pekerjaan
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * metode untuk mendapatkan nilai bayaran dari pekerjaan
     * @return nilai bayaran
     */
    public int getFee()
    {
        return fee;
    }
    
    /**
     * metode untuk mendapatkan kategori pekerjaan
     * @return kategori pekerjaan
     */
    public JobCategory getCategory()
    {
        return category;
    }
    
    /**
     * metode untuk mendapatkan objek pemilik pekerjaan
     * @return objek pemilik pekerjaan
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
    }
    
    /**
     * metode untuk mengubah id pekerjaan
     * @param id id pekerjaan
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * metode untuk mengubah nama pekerjaan
     * @param name nama pekerjaan
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * metode untuk mengubah nilai bayaran pekerjaan
     * @param fee nilai bayaran
     */
    public void setFee(int fee)
    {
        this.fee = fee;
    }
    
    /**
     * metode untuk mengubah kategori pekerjaan
     * @param category kategori pekerjaan
     */
    public void setCategory(JobCategory category){
        this.category = category;
    }
    
    /**
     * metode untuk mengubah pemilik pekerjaan
     * @param recruiter objek pemilik pekerjaan
     */
    public void setRecruiter(Recruiter recruiter)
    {
        this.recruiter = recruiter;
    }
    
    /** metode untuk melakukan return data */
    public String toString()
    {
        String returnValue = "===================== JOB =====================" + "\n" +
                             "ID: " + id + "\n" +
                             "Name: " + name + "\n" +
                             "Recruiter: " + recruiter.getName() + "\n" +
                             "City: " + recruiter.getLocation().getCity() + "\n" +
                             "Fee: " + fee + "\n" +
                             "Category: " + category.toString() + "\n";
        return returnValue;
    }
}

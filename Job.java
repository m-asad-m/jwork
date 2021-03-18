/**
 * class Job.
 *
 * @author Muhammad As'ad Muyassir
 * @version 18-03-2021
 */
public class Job
{
    private int id, fee;
    private String name, category;
    Recruiter recruiter;

    /**
     * Constructor for objects of class Invoice
     */
    public Job(int id, String name, Recruiter recruiter, int fee, String category)
    {
        this.id = id;
        this.name = name;
        this.recruiter = recruiter;
        this.fee = fee;
        this.category = category;
    }
    
    /**
     * get id method
     * @return id of job
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * get name method
     * @return name of job
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * get fee method
     * @return fee of job
     */
    public int getFee()
    {
        return fee;
    }
    
    /**
     * get category method
     * @return category of job
     */
    public String getCategory()
    {
        return category;
    }
    
    /**
     * get recruited method
     * @return recruiter object of job
     */
    public Recruiter getRecruiter()
    {
        return recruiter;
    }
    
    /**
     * set id method
     * @param id an parameter for job id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * set name method
     * @param name an parameter for job name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * set fee method
     * @param fee an parameter for job fee
     */
    public void setFee(int fee)
    {
        this.fee = fee;
    }
    
    /**
     * set category method
     * @param category an parameter for job category
     */
    public void setCategory(String category){
        this.category = category;
    }
    
    /**
     * set category method
     * @param recruiter an parameter for job recruiter object
     */
    public void setRecruiter(Recruiter recruiter)
    {
        this.recruiter = recruiter;
    }
    
    /** print data method */
    public void printData()
    {
        
    }
}

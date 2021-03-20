/**
 * Class Jobseeker adalah class yang menyimpan data pencari pekerjaan.
 *
 * @author Muhammad As'ad Muyassir
 * @version 18-03-2021
 */
public class Jobseeker
{
    private int id;
    private String name, email, password, joinDate;

    /**
     * Constructor untuk objek dari class Jobseeker
     * @param id       id pencari pekerjaan
     * @param name     nama pencari pekerjaan
     * @param email    email pencari pekerjaan
     * @param password password pencari pekerjaan
     * @param joinDate tanggal join pencari pekerjaan
     */
    public Jobseeker(int id, String name, String email, String password, String joinDate)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
    }
    
    /**
     * metode untuk mendapatkan id pencari pekerjaan
     * @return id pencari pekerjaan
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * metode untuk mendapatkan nama pencari pekerjaan
     * @return nama pencari pekerjaan
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * metode untuk mendapatkan email pencari pekerjaan
     * @return email pencari pekerjaan
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * metode untuk mendapatkan password pencari pekerjaan
     * @return password pencari pekerjaan
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * metode untuk mendapatkan tanggal join pencari pekerjaan
     * @return tanggal join pencari pekerjaan
     */
    public String getJoinDate()
    {
        return joinDate;
    }
    
    /**
     * metode untuk mengubah id pencari pekerjaan
     * @param id id pencari pekerjaan
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * metode untuk mengubah nama pencari pekerjaan
     * @param name nama pencari pekerjaan
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * metode untuk mengubah email pencari pekerjaan
     * @param email email pencari pekerjaan
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * metode untuk mengubah password pencari pekerjaan
     * @param password password pencari pekerjaan
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * metode untuk mengubah tanggal join pencari pekerjaan
     * @param joinDate tanggal join pencari pekerjaan
     */
    public void setJoinDate(String joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /** metode untuk melakukan print nama pencari kerja pada terminal */
    public void printData()
    {
        System.out.println(name);
    }
}
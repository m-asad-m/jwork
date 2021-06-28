package MuhammadAsadMuyassir.jwork.object;

/**
 * Class Recruiter adalah class yang menyimpan data perekrut
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public class Recruiter
{
    private int id;
    private String name, email, phoneNumber;
    private Location location;

    /**
     * Constructor untuk objek dari class Recruiter
     *
     * @param id          id perekrut
     * @param name        nama perekrut
     * @param email       email perekrut
     * @param phoneNumber nomor telepon perekrut
     * @param location    lokasi perekrut
     */
    public Recruiter(int id, String name, String email, String phoneNumber, Location location)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
    }
    
    /**
     * Metode untuk mendapatkan id perekrut
     *
     * @return id recruiter
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Metode untuk mendapatkan nama perekrut
     *
     * @return nama recruiter
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Metode untuk mendapatkan email perekrut
     *
     * @return email recruiter
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Metode untuk mendapatkan nomor telepon perekrut
     *
     * @return nomor telepon recruiter
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Metode untuk mendapatkan lokasi perekrut
     *
     * @return objek lokasi recruiter
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Metode untuk mengubah id perekrut
     *
     * @param id id recruiter
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Metode untuk mengubah nama perekrut
     *
     * @param name nama recruiter
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Metode untuk mengubah email perekrut
     *
     * @param email email recruiter
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Metode untuk mengubah nomor telepon perekrut
     *
     * @param phoneNumber nomor telepon recruiter
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Metode untuk mengubah lokasi perekrut
     *
     * @param location objek lokasi recruiter
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    /** Metode untuk mendapatkan objek Recruiter dalam bentuk string */
    public String toString()
    {
        String returnValue = "===================== RECRUITER =====================" + "\n" +
                             "ID = " + id + "\n" +
                             "Name = " + name + "\n" +
                             "PhoneNumber = " + phoneNumber + "\n" +
                             "Location = " + location.getDescription() + "\n";
        return returnValue;
    }
}

/**
 * Class Location adalah class yang menyimpan lokasi recruiter
 *
 * @author Muhammad As'ad Muyassir
 * @version 18-03-2021
 */
public class Location
{
    private String province, city, description;
    
    /**
     * Constructor for objects of class Location
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }
    
    /**
     * metode get province untuk mendapatkan nilai provinsi
     * @return province nilai provinsi dari objek
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * metode get city untuk mendapatkan nilai kota
     * @return city nilai kota dari objek
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * metode get description untuk mendapatkan deskripsi dari lokasi
     * @return deskripsi nilai deskripsi dari objek
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * metode set province untuk mengubah provinsi dari lokasi
     * @param province nilai provinsi yang diinginkan
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * metode set city untuk mengubah kota dari lokasi
     * @param city nilai kota yang diinginkan
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * metode set description untuk mengubah deskripsi dari lokasi
     * @param description nilai deskripsi yang diinginkan
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /** untuk melakukan print data provinsi */
    public void printData()
    {
        System.out.println(province);
    }
}
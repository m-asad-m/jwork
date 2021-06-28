package MuhammadAsadMuyassir.jwork.object;

/**
 * Class Location adalah class yang menyimpan lokasi perekrut
 *
 * @author Muhammad As'ad Muyassir
 * @version 18-03-2021
 */
public class Location
{
    private String province, city, description;
    
    /**
     * Constructor untuk objek dari class Location
     *
     * @param province    nama provinsi
     * @param city        nama kota
     * @param description deskripsi lokasi
     */
    public Location(String province, String city, String description)
    {
        this.province = province;
        this.city = city;
        this.description = description;
    }
    
    /**
     * Metode untuk mendapatkan nama provinsi
     *
     * @return nama provinsi dari objek
     */
    public String getProvince()
    {
        return province;
    }
    
    /**
     * Metode untuk mendapatkan nama kota
     *
     * @return nama kota dari objek
     */
    public String getCity()
    {
        return city;
    }
    
    /**
     * Metode untuk mendapatkan deskripsi dari lokasi
     *
     * @return deskripsi dari objek
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Metode untuk mengubah nama provinsi dari lokasi
     *
     * @param province nama provinsi
     */
    public void setProvince(String province)
    {
        this.province = province;
    }
    
    /**
     * Metode untuk mengubah nama kota dari lokasi
     *
     * @param city nama kota
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    
    /**
     * Metode untuk mengubah deskripsi dari lokasi
     *
     * @param description deskripsi lokasi
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /** Metode untuk mendapatkan objek Location dalam bentuk string */
    public String toString()
    {
        String returnValue = "===================== LOCATION =====================" + "\n" +
                             "Province = " + province + "\n" +
                             "City = " + city + "\n" +
                             "Description = " + description + "\n";
        return returnValue;
    }
}
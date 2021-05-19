package MuhammadAsadMuyassir.jwork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.regex.*;

/**
 * Class Jobseeker adalah class yang menyimpan data pencari pekerjaan.
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public class Jobseeker
{
    private int id;
    private String name, email, password;
    Calendar joinDate;

    /**
     * Constructor untuk objek dari class Jobseeker
     * @param id       id pencari pekerjaan
     * @param name     nama pencari pekerjaan
     * @param email    email pencari pekerjaan
     * @param password password pencari pekerjaan
     * @param joinDate objek gregorian calendar join pencari pekerjaan
     */
    public Jobseeker(int id, String name, String email, String password, Calendar joinDate)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        this.joinDate = joinDate;
    }
    
    /**
     * Constructor untuk objek dari class Jobseeker
     * @param id         id pencari pekerjaan
     * @param name       nama pencari pekerjaan
     * @param email      email pencari pekerjaan
     * @param password   password pencari pekerjaan
     * @param year       tahun join pencari pekerjaan
     * @param month      bulan join pencari pekerjaan
     * @param dayOfMonth tanggal join pencari pekerjaan
     */
    public Jobseeker(int id, String name, String email, String password, int year, int month, int dayOfMonth)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        joinDate = new GregorianCalendar(year, month-1, dayOfMonth);
    }
    
    /**
     * Constructor untuk objek dari class Jobseeker
     * @param id       id pencari pekerjaan
     * @param name     nama pencari pekerjaan
     * @param email    email pencari pekerjaan
     * @param password password pencari pekerjaan
     */
    public Jobseeker(int id, String name, String email, String password)
    {
        this.id = id;
        this.name = name;
        setEmail(email);
        setPassword(password);
        joinDate = Calendar.getInstance();
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
    public Calendar getJoinDate()
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
        String pattern = "^[\\w&*~](\\.?[\\w&*~]+)*@\\w[-\\w&*~\\.]+$";
        if(Pattern.matches(pattern, email))
        {
            this.email = email;
        }
        else
        {
            this.email = "";
            System.out.println("Email anda tidak sesuai dengan pola yang benar");
        }
    }
    
    /**
     * metode untuk mengubah password pencari pekerjaan
     * @param password password pencari pekerjaan
     */
    public void setPassword(String password)
    {
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}$";
        if(Pattern.matches(pattern, password))
        {
            this.password = password;
        }
        else
        {
            this.password = "";
            System.out.println("Password anda tidak sesuai dengan pola yang benar");
        }
    }
    
    /**
     * metode untuk mengubah tanggal join pencari pekerjaan
     * @param joinDate objek gregorian calendar join pencari pekerjaan
     */
    public void setJoinDate(Calendar joinDate)
    {
        this.joinDate = joinDate;
    }
    
    /**
     * metode untuk mengubah tanggal join pencari pekerjaan
     * @param year       tahun join pencari pekerjaan
     * @param month      bulan join pencari pekerjaan
     * @param dayOfMonth tanggal join pencari pekerjaan
     */
    public void setJoinDate(int year, int month, int dayOfMonth)
    {
        joinDate.set(year, month-1, dayOfMonth);
    }
    
    /** metode untuk melakukan return nama pencari kerja */
    public String toString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        String returnValue = "===================== JOB SEEKER =====================" + "\n" +
                             "Id = " + id + "\n" +
                             "Nama = " + name + "\n" +
                             "Email = " + email + "\n" +
                             "Password = " + password + "\n" +
                             "Join Date = " + sdf.format(joinDate.getTime()) + "\n";
        return returnValue;
    }
}
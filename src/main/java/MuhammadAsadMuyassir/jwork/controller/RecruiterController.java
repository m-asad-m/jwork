package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.object.Location;
import MuhammadAsadMuyassir.jwork.object.Recruiter;
import MuhammadAsadMuyassir.jwork.exception.RecruiterNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.EmailAlreadyExistsException;
import MuhammadAsadMuyassir.jwork.exception.PhoneNumberAlreadyExistsException;
import MuhammadAsadMuyassir.jwork.database.DatabaseRecruiterPostgre;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class RecruiterController adalah class yang menghandle seluruh request perekrut
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {

    /**
     * Metode untuk mendapatkan seluruh perekrut yang ada pada database
     *
     * @return array list seluruh perekrut
     */
    @RequestMapping("")
    public ArrayList<Recruiter> getAllRecruiter()
    {
        return DatabaseRecruiterPostgre.getRecruiter();
    }

    /**
     * Metode untuk mendapatkan perekrut berdasarkan id
     *
     * @param id                            id perekrut
     * @return                              objek perekrut
     * @throws RecruiterNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id)
            throws  RecruiterNotFoundException
    {
        return DatabaseRecruiterPostgre.getRecruiterById(id);
    }

    /**
     * Metode untuk menambahkan perekrut ke dalam database
     * 
     * @param name                                  nama perekrut
     * @param email                                 email perekrut
     * @param phoneNumber                           nomor telepon perekrut
     * @param province                              provinsi lokasi perekrut
     * @param city                                  kota lokasi perekrut
     * @param description                           deskripsi lokasi perekrut
     * @return                                      boolean status keberhasilan
     * @throws EmailAlreadyExistsException          jika email sudah terdapat dalam database
     * @throws PhoneNumberAlreadyExistsException    jika nomor telepon sudah terdapat dalam database
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addRecruiter(@RequestParam(value="name") String name,
                                @RequestParam(value="email") String email,
                                @RequestParam(value="phoneNumber") String phoneNumber,
                                @RequestParam(value="province") String province,
                                @RequestParam(value="city") String city,
                                @RequestParam(value="description") String description)
            throws EmailAlreadyExistsException, PhoneNumberAlreadyExistsException
    {
        return DatabaseRecruiterPostgre.addRecruiter(new Recruiter(0, name, email, phoneNumber, new Location(province, city, description)));
    }

    /**
     * Metode untuk menghapus perekrut dari database
     *
     * @param id                            id perekrut
     * @return                              boolean status keberhasilan
     * @throws RecruiterNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/removeRecruiter/{id}", method = RequestMethod.DELETE)
    public boolean removeRecruiter(@PathVariable int id)
            throws RecruiterNotFoundException
    {
        return DatabaseRecruiterPostgre.removeRecruiter(id);
    }
}

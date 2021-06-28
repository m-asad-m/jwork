package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.object.Jobseeker;
import MuhammadAsadMuyassir.jwork.exception.JobSeekerNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.EmailAlreadyExistsException;
import MuhammadAsadMuyassir.jwork.database.DatabaseJobseekerPostgre;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

/**
 * Class JobseekerController adalah class yang menghandle seluruh request pencari pekerjaan
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * Metode untuk mendapatkan seluruh pencari pekerjaan yang ada pada database
     *
     * @return array list seluruh pencari pekerjaan
     */
    @RequestMapping("")
    public ArrayList<Jobseeker> getAllJobseeker()
    {
        return DatabaseJobseekerPostgre.getJobseeker();
    }

    /**
     * Metode untuk mendapatkan pencari pekerjaan berdasarkan id
     *
     * @param id                            id pencari pekerjaan
     * @return                              objek pencari pekerjaan
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id)
            throws JobSeekerNotFoundException
    {
        return DatabaseJobseekerPostgre.getJobseekerById(id);
    }

    /**
     * Metode untuk mendapatkan id terakhir
     * @return  integer id
     */
    @RequestMapping("/getLastID")
    public int getLastJobseekerID()
    {
        return DatabaseJobseekerPostgre.getLastJobseekerID();
    }

    /**
     * Metode untuk menghapus pencari pekerjaan dari database
     *
     * @param id                            id pencari pekerjaan
     * @return                              boolean status keberhasilan
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/removeJobseeker/{id}", method = RequestMethod.DELETE)
    public boolean removeJobseeker(@PathVariable int id)
            throws JobSeekerNotFoundException
    {
        return DatabaseJobseekerPostgre.removeJobseeker(id);
    }

    /**
     * Metode untuk menambahkan pencari pekerjaan ke dalam database
     *
     * @param name                          nama pencari pekerjaan
     * @param email                         email pencari pekerjaan
     * @param password                      password pencari pekerjaan
     * @return                              integer id pencari pekerjaan yang baru tidambahkan
     * @throws EmailAlreadyExistsException  jika email sudah terdapat dalam database
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public int registerJobseeker(@RequestParam(value="name") String name,
                                 @RequestParam(value="email") String email,
                                 @RequestParam(value="password") String password)
            throws EmailAlreadyExistsException
    {
        return DatabaseJobseekerPostgre.addJobseeker(new Jobseeker(0, name, email, password));
    }

    /**
     * Metode untuk melakukan login pencari pekerjaan
     *
     * @param email                         email pencari pekerjaan
     * @param password                      password pencari pekerjaan
     * @return                              objek pencari pekerjaan
     * @throws JobSeekerNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value="email") String email,
                                    @RequestParam(value="password") String password)
            throws JobSeekerNotFoundException
    {
        return DatabaseJobseekerPostgre.jobseekerLogin(email, password);
    }
}
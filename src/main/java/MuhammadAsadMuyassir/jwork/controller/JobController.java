package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.object.Job;
import MuhammadAsadMuyassir.jwork.enumeration.JobCategory;
import MuhammadAsadMuyassir.jwork.exception.JobNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.RecruiterNotFoundException;
import MuhammadAsadMuyassir.jwork.database.DatabaseJobPostgre;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class JobController adalah class yang menghandle seluruh request pekerjaan
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * Metode untuk mendapatkan seluruh pekerjaan yang ada pada database
     *
     * @return array list seluruh pekerjaan
     */
    @RequestMapping("")
    public ArrayList<Job> getAllJob()
    {
        return DatabaseJobPostgre.getJob();
    }

    /**
     * Metode untuk mendapatkan pekerjaan berdasarkan id
     *
     * @param id                    id pekerjaan
     * @return                      objek pekerjaan
     * @throws JobNotFoundException jika id tidak ditemukan dalam database
     */
    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id)
            throws JobNotFoundException
    {
        return DatabaseJobPostgre.getJobById(id);
    }

    /**
     * Metode untuk mendapatkan pekerjaan berdasarkan perekrut
     *
     * @param recruiterId   id perekrut
     * @return              array list pekerjaan
     */
    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId)
    {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    /**
     * Metode untuk mendapatkan pekerjaan berdasarkan kategori
     *
     * @param category      enum kategori pekerjaan
     * @return              array list pekerjaan
     */
    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category)
    {
        return DatabaseJobPostgre.getJobByCategory(category);
    }

    /**
     * Metode untuk mendapatkan seluruh kategori pekerjaan
     *
     * @return  list enum kategori pekerjaan
     */
    @RequestMapping("/allCategory")
    public JobCategory[] getAllJobCategory()
    {
        return JobCategory.values();
    }

    /**
     * Metode untuk menambahkan pekerjaan ke dalam database
     *
     * @param name                          nama pekerjaan
     * @param recruiterId                   id perekrut
     * @param fee                           bayaran pekerjaan
     * @param category                      kategori pekerjaan
     * @return                              boolean status keberhasilan
     * @throws RecruiterNotFoundException   jika perekrut tidak ditemukan dalam database
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addJob(@RequestParam(value="name") String name,
                          @RequestParam(value="recruiterId") int recruiterId,
                          @RequestParam(value="fee") int fee,
                          @RequestParam(value="category") JobCategory category)
            throws RecruiterNotFoundException
    {
        return DatabaseJobPostgre.addJob(new Job(0, name, null, fee, category), recruiterId);
    }

    /**
     * Metode untuk menghapus pekerjaan dari database
     *
     * @param id                    id pekerjaan
     * @return                      boolean status keberhasilan
     * @throws JobNotFoundException jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/removeJob/{id}", method = RequestMethod.DELETE)
    public boolean removeJob(@PathVariable int id)
            throws JobNotFoundException
    {
        return DatabaseJobPostgre.removeJob(id);
    }
}

package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobController {

    @RequestMapping("")
    public ArrayList<Job> getAllJob() {
        return DatabaseJob.getJobDatabase();
    }

    @RequestMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        Job job = null;
        try {
            job = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException e) {
            e.getMessage();
            return null;
        }
        return job;
    }

    @RequestMapping("/recruiter/{recruiterId}")
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJob.getJobByRecruiter(recruiterId);
    }

    @RequestMapping("/category/{category}")
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJob.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value="name") String name,
                      @RequestParam(value="recruiterId") int recruiterId,
                      @RequestParam(value="fee") int fee,
                      @RequestParam(value="category") JobCategory category)
    {
        Recruiter recruiter = null;
        try {
            recruiter = DatabaseRecruiter.getRecruiterById(recruiterId);
        } catch (RecruiterNotFoundException e) {
            e.getMessage();
            return null;
        }

        Job job = new Job(DatabaseJob.getLastId()+1, name, recruiter, fee, category);
        DatabaseJob.addJob(job);
        return job;
    }
}

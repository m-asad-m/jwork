package MuhammadAsadMuyassir.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JWork {
    public static void main(String[] args) {
        Location location1 = new Location("Jawa Barat", "Bekasi", "Rumah");
        Location location2 = new Location("Jawa Timur", "Yogyakarta", "Daerah Istimewa");
        Location location3 = new Location("DKI Jakarta", "Jakarta", "Ibu Kota");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "As'ad", "muhammad.asad@ui.ac.id", "089583948293", location1));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "Aad", "muhammad.asad@gmail.com", "089591857483", location2));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "M As'ad M", "muhammad.asad@yahoo.com", "089516473847", location3));

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Web Developer", DatabaseRecruiter.getRecruiterById(1), 10000000, JobCategory.WebDeveloper));
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Junior Web Developer", DatabaseRecruiter.getRecruiterById(2), 20000000, JobCategory.WebDeveloper));
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Software Engineer", DatabaseRecruiter.getRecruiterById(3), 30000000, JobCategory.DataScientist));
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Designer", DatabaseRecruiter.getRecruiterById(3), 30000000, JobCategory.UI));
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        SpringApplication.run(JWork.class, args);
    }
}
import java.util.GregorianCalendar;

public class JWork
{
    public static void main(String[] args)
    {
        Location location = new Location("West Java", "Bekasi", "My House");
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "As'ad", "muhammad.asad@ui.ac.id", "0895333889470", location));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Muhammad As'ad Muyassir", "muhammad.asad@ui.ac.id", "Password123", 2021, 4, 22));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Muhammad As'ad Muyassir", "muhammad.asad@ui.ac.id", "Password112233", 2021, 4, 22));
        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Hansaka Wijaya", "hansaka.wijaya@ui.ac.id", "Password123", 2021, 4, 22));

        for(Jobseeker jobseeker: DatabaseJobseeker.getJobseekerDatabase()){
            System.out.println(jobseeker.toString());
        }

        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "BONUSBONUS", 101010, 15000000, false));
        DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "BONUSBONUS", 101010, 25000000, true));

        for(Bonus bonus: DatabaseBonus.getBonusDatabase()){
            System.out.println(bonus.toString());
        }

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Web Developer", DatabaseRecruiter.getRecruiterById(1), 10000000, JobCategory.WebDeveloper));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Junior Web Developer", DatabaseRecruiter.getRecruiterById(1), 20000000, JobCategory.WebDeveloper));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Designer", DatabaseRecruiter.getRecruiterById(1), 30000000, JobCategory.UI));

        for(Job job: DatabaseJob.getJobByCategory(JobCategory.WebDeveloper)){
            System.out.println(job.toString());
        }

        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1)));
    }
}
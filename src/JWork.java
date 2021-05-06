import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JWork
{
    public static void main(String[] args)
    {
        Location location = new Location("West Java", "Bekasi", "My House");
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId()+1, "As'ad", "muhammad.asad@ui.ac.id", "0895333889470", location));
        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Muhammad As'ad Muyassir", "muhammad.asad@ui.ac.id", "Password123", 2021, 4, 22));
        }
        catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Muhammad As'ad Muyassir", "muhammad.asad@ui.ac.id", "Password123", 2021, 4, 22));
        }
        catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Muhammad As'ad Muyassir", "muhammad.asad@gmail.com", "Password123", 2021, 4, 22));
        }
        catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId()+1, "Hansaka Wijaya", "hansaka.wijaya@ui.ac.id", "Password123", 2021, 4, 22));
        }
        catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "BONUSBONUS", 101010, 15000000, false));
        }
        catch(ReferralCodeAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseBonus.addBonus(new Bonus(DatabaseBonus.getLastId()+1, "BONUSBONUS", 101010, 25000000, true));
        }
        catch(ReferralCodeAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJobseeker.getJobseekerById(2000);
        }
        catch(JobSeekerNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseRecruiter.getRecruiterById(2000);
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJob.getJobById(2000);
        }
        catch(JobNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseBonus.getBonusById(2000);
        }
        catch(BonusNotFoundException error) {
            System.out.println(error.getMessage());
        }

        for(Jobseeker jobseeker: DatabaseJobseeker.getJobseekerDatabase()) {
            System.out.println(jobseeker.toString());
        }

        for(Bonus bonus: DatabaseBonus.getBonusDatabase()){
            System.out.println(bonus.toString());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Web Developer", DatabaseRecruiter.getRecruiterById(1), 10000000, JobCategory.WebDeveloper));
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Junior Web Developer", DatabaseRecruiter.getRecruiterById(1), 20000000, JobCategory.WebDeveloper));
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJob.addJob(new Job(DatabaseJob.getLastId()+1, "Senior Designer", DatabaseRecruiter.getRecruiterById(1), 30000000, JobCategory.UI));
        }
        catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        Invoice invoice1 = null;
        Invoice invoice2 = null;
        Invoice invoice3 = null;

        try {
            invoice1 = new BankPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1));
        }
        catch(JobSeekerNotFoundException error) {
            System.out.println(error.getMessage());
        }

        DatabaseInvoice.addInvoice(invoice1);

        try {
            invoice2 = new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(2));
        }
        catch(JobSeekerNotFoundException error) {
            System.out.println(error.getMessage());
        }

        DatabaseInvoice.addInvoice(invoice2);

        try {
            invoice3 = new EwalletPayment(DatabaseInvoice.getLastId()+1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(3), DatabaseBonus.getBonusByReferralCode("BONUSBONUS"));
        }
        catch(JobSeekerNotFoundException error) {
            System.out.println(error.getMessage());
        }

        DatabaseInvoice.addInvoice(invoice3);

        FeeCalculator t1 = new FeeCalculator(invoice1);
        FeeCalculator t2 = new FeeCalculator(invoice2);
        FeeCalculator t3 = new FeeCalculator(invoice3);

        Thread thread1 = new Thread(t1);
        thread1.start();
        Thread thread2 = new Thread(t2);
        thread2.start();
        Thread thread3 = new Thread(t3);
        thread3.start();
    }
}
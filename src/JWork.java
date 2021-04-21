import java.util.GregorianCalendar;

public class JWork
{
    public static void main(String[] args)
    {
        Location location = new Location("West Java", "Bekasi", "My House");
        Recruiter recruiter = new Recruiter(1, "As'ad", "muhammad.asad@ui.ac.id", "0895333889470", location);
        Job job = new Job(1, "Senior Designer", recruiter, 10000000, JobCategory.WebDeveloper);
        Jobseeker jobseeker = new Jobseeker(1, "bambang", "bamb..ang@gmail.com", "123123", new GregorianCalendar(2021, 4, 8));
        Jobseeker jobseeker1 = new Jobseeker(2, "bambang", "bambang@gmail.com", "Password123", 2021, 4, 8);
        Jobseeker jobseeker2 = new Jobseeker(3, "bambang", "bambang@gmail.com", "Password123");
        
        System.out.println(jobseeker.toString());
        System.out.println(jobseeker1.toString());
        System.out.println(jobseeker2.toString());
        
        jobseeker.setEmail("bambang@gmail.com");
        jobseeker.setPassword("Password123");
        
        System.out.println(jobseeker.toString());
        
        Bonus bonus = new Bonus(1, "abcdefg", 10000, 10000, true);
        EwalletPayment epay = new EwalletPayment(2, job, jobseeker, bonus, InvoiceStatus.OnGoing);
        epay.setTotalFee();
        System.out.println(epay.toString());
        
        BankPayment bpay = new BankPayment(1, job, jobseeker, InvoiceStatus.Finished, 10000);
        bpay.setTotalFee();
        System.out.println(bpay.toString());
    }
}
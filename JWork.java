public class JWork
{
    public static void main(String[] args)
    {
        Location location = new Location("West Java", "Bekasi", "My House");
        Recruiter recruiter = new Recruiter(1, "As'ad", "muhammad.asad@ui.ac.id", "0895333889470", location);
        Job job = new Job(1, "Senior Designer", recruiter, 10000000, JobCategory.WebDeveloper);
        Jobseeker jobseeker = new Jobseeker(1, "bambang", "bambang@gmail.com", "123123", "30-02-1985");
        Invoice invoice = new Invoice(123123, 123123, "18-03-2021", 10000000, jobseeker);
        
        System.out.println(recruiter.getName());
        recruiter.setName("Hansaka Wijaya");
        System.out.println(recruiter.getName());
        job.printData();
    }
}
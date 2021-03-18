public class JWork
{
    public static void main(String[] args)
    {
        Location location1 = new Location("West Java", "Bekasi", "My House");
        Recruiter recruiter1 = new Recruiter(123123, "Saya", "123123@ui.ac.id", "123123", location1);
        Job job1 = new Job(123123, "ML Engineer", recruiter1, 10000000, "Engineer");
        Jobseeker jobseeker1 = new Jobseeker(123123, "UI", "ui@ui.ac.id", "uiiiiii", "30-02-1985");
        Invoice invoice1 = new Invoice(123123, 123123, "18-03-2021", 10000000, jobseeker1);
    }
}
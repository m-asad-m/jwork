public class JWork
{
    public static void main(String[] args)
    {
        Location location = new Location("West Java", "Bekasi", "My House");
        Recruiter recruiter = new Recruiter(1, "As'ad", "muhammad.asad@ui.ac.id", "0895333889470", location);
        Job job = new Job(1, "Senior Designer", recruiter, 10000000, JobCategory.WebDeveloper);
        Jobseeker jobseeker = new Jobseeker(1, "bambang", "bambang@gmail.com", "123123", "30-02-1985");
        Bonus bonus0 = new Bonus(1, "abcdefg", 10000, 10000, true);
        Bonus bonus1 = new Bonus(2, "hijklmn", 10000, 20000000, true);
        EwalletPayment epay0 = new EwalletPayment(1, job, "01-04-2021", jobseeker, InvoiceStatus.OnGoing);
        EwalletPayment epay1 = new EwalletPayment(2, job, "01-04-2021", jobseeker, bonus0, InvoiceStatus.OnGoing);
        EwalletPayment epay2 = new EwalletPayment(3, job, "01-04-2021", jobseeker, bonus1, InvoiceStatus.OnGoing);
        
        epay0.setTotalFee();
        epay1.setTotalFee();
        epay2.setTotalFee();
        
        epay0.printData();
        epay1.printData();
        epay2.printData();
        
        BankPayment bpay0 = new BankPayment(1, job, "03-04-2021", jobseeker, InvoiceStatus.Finished);
        BankPayment bpay1 = new BankPayment(2, job, "03-04-2021", jobseeker, InvoiceStatus.Finished, 10000);
        
        bpay0.setTotalFee();
        bpay1.setTotalFee();
        
        bpay0.printData();
        bpay1.printData();
    }
}
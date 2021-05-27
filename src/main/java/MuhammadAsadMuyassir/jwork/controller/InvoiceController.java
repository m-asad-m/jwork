package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id)
    {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        return invoice;
    }

    @RequestMapping("/Jobseeker/{JobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int JobseekerId)
    {
        return DatabaseInvoice.getInvoiceByJobSeeker(JobseekerId);
    }

    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value="status") InvoiceStatus status)
    {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return null;
        }
        invoice.setInvoiceStatus(status);
        return invoice;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id)
    {
        try {
            return DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="adminFee", defaultValue="0") int adminFee)
    {
        BankPayment bank = null;
        ArrayList<Job> job = new ArrayList<Job>();
        for(int id: jobIdList)
        {
            try {
                job.add(DatabaseJob.getJobById(id));
            } catch (JobNotFoundException e) {
                e.getMessage();
                continue;
            }
        }

        try {
            bank = new BankPayment(DatabaseInvoice.getLastId()+1, job, DatabaseJobseeker.getJobseekerById(jobseekerId), adminFee);
            bank.setTotalFee();
            DatabaseInvoice.addInvoice(bank);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }

        return bank;
    }

    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                     @RequestParam(value="jobseekerId") int jobseekerId,
                                     @RequestParam(value = "bonus", defaultValue="") String referralCode)
    {
        EwalletPayment eWallet = null;
        ArrayList<Job> job = new ArrayList<Job>();
        for(int id: jobIdList)
        {
            try {
                job.add(DatabaseJob.getJobById(id));
            } catch (JobNotFoundException e) {
                e.getMessage();
                continue;
            }
        }

        try {
            eWallet = new EwalletPayment(DatabaseInvoice.getLastId()+1, job, DatabaseJobseeker.getJobseekerById(jobseekerId), DatabaseBonus.getBonusByReferralCode(referralCode));
            eWallet.setTotalFee();
            DatabaseInvoice.addInvoice(eWallet);
        } catch (JobSeekerNotFoundException e) {
            e.getMessage();
            return null;
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }

        return eWallet;
    }
}
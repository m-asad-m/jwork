package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.object.Invoice;
import MuhammadAsadMuyassir.jwork.enumeration.InvoiceStatus;
import MuhammadAsadMuyassir.jwork.exception.*;
import MuhammadAsadMuyassir.jwork.database.DatabaseInvoicePostgre;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class InvoiceController adalah class yang menghandle seluruh request bonus
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {

    /**
     * Metode untuk mendapatkan seluruh invoice yang ada pada database
     *
     * @return array list seluruh invoice
     */
    @RequestMapping("")
    public ArrayList<Invoice> getAllInvoice()
    {
        return DatabaseInvoicePostgre.getInvoice();
    }

    /**
     * Metode untuk mendapatkan invoice berdasarkan id
     *
     * @param id                        id invoice
     * @return                          objek invoice
     * @throws InvoiceNotFoundException jika id tidak ditemukan dalam database
     */
    @RequestMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable int id)
            throws InvoiceNotFoundException
    {
        return DatabaseInvoicePostgre.getInvoiceById(id);
    }

    /**
     * Metode untuk mendapatkan invoice berdasarkan id jobseeker
     *
     * @param jobseekerId   id jobseeker
     * @return              array list invoice
     */
    @RequestMapping("/jobseeker/{JobseekerId}")
    public ArrayList<Invoice> getInvoiceByJobseeker(@PathVariable int jobseekerId)
    {
        return DatabaseInvoicePostgre.getInvoiceByJobseeker(jobseekerId);
    }

    /**
     * Metode untuk mengubah status invoice
     *
     * @param id                        id invoice
     * @param status                    enum status invoice
     * @return                          boolean status keberhasilan
     * @throws InvoiceNotFoundException jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public boolean changeInvoiceStatus(@PathVariable int id,
                                       @RequestParam(value="status") InvoiceStatus status)
            throws InvoiceNotFoundException
    {
        return DatabaseInvoicePostgre.changeInvoiceStatus(id, status);
    }

    /**
     * Metode untuk menghapus invoice dari database
     *
     * @param id                        id invoice
     * @return                          boolean status keberhasilan
     * @throws InvoiceNotFoundException jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/removeInvoice/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@PathVariable int id) throws
            InvoiceNotFoundException
    {
        return DatabaseInvoicePostgre.removeInvoice(id);
    }

    /**
     * Metode untuk menambahkan invoice dengan tipe pembayaran BankPayment ke dalam database
     *
     * @param jobIdList                             list job
     * @param jobseekerId                           id jobseeker
     * @param adminFee                              biaya admin; nilai default 0
     * @return                                      boolean status keberhasilan
     * @throws OngoingInvoiceAlreadyExistsException jika jobseeker telah memiliki invoice yang berstatus OnGoing
     * @throws JobNotFoundException                 jika terdapat job yang tidak ditemukan dalam database
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public boolean addBankPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                  @RequestParam(value="jobseekerId") int jobseekerId,
                                  @RequestParam(value="adminFee", defaultValue="0") int adminFee)
            throws OngoingInvoiceAlreadyExistsException, JobNotFoundException
    {
        return DatabaseInvoicePostgre.addBankPayment(jobIdList, jobseekerId, adminFee);
    }

    /**
     * Metode untuk menambahkan invoice dengan tipe pembayaran EWalletPayment ke dalam database
     *
     * @param jobIdList                             list job
     * @param jobseekerId                           id jobseeker
     * @param referralCode                          kode referral; nilai default kosong
     * @return                                      boolean status keberhasilan
     * @throws OngoingInvoiceAlreadyExistsException jika jobseeker telah memiliki invoice yang berstatus OnGoing
     * @throws JobNotFoundException                 jika terdapat job yang tidak ditemukan dalam database
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public boolean addEWalletPayment(@RequestParam(value="jobIdList") ArrayList<Integer> jobIdList,
                                     @RequestParam(value="jobseekerId") int jobseekerId,
                                     @RequestParam(value = "referralCode", defaultValue="") String referralCode)
            throws OngoingInvoiceAlreadyExistsException, JobNotFoundException
    {
        return DatabaseInvoicePostgre.addEwalletPayment(jobIdList, jobseekerId, referralCode);
    }
}
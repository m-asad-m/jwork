package MuhammadAsadMuyassir.jwork;

import java.util.ArrayList;

/**
 * Class Database Invoice.
 *
 * @author Muhammad As'ad Muyassir
 * @version 24-04-2021
 */
public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList<Invoice>();
    private static int lastId = 0;

    /**
     * metode untuk mendapatkan list invoice
     * @return array list invoice
     */
    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }

    /**
     * metode untuk mendapatkan id terakhir
     * @return id terakhir
     */
    public static int getLastId()
    {
        return lastId;
    }

    /**
     * metode untuk mendapatkan list invoice berdasarkan id
     * @param  id   id invoice
     * @return      objek invoice
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoice: INVOICE_DATABASE)
        {
            if(invoice.getId() == id)
            {
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
    }

    /**
     * metode untuk mendapatkan list invoice berdasarkan id jobseeker
     * @param  jobseekerId  id jobseeker
     * @return              array list invoice
     */
    public static ArrayList<Invoice> getInvoiceByJobSeeker(int jobseekerId)
    {
        ArrayList<Invoice> returnValue = new ArrayList<Invoice>();
        for(Invoice invoice: INVOICE_DATABASE)
        {
            if(invoice.getJobseeker().getId() == jobseekerId)
            {
                returnValue.add(invoice);
            }
        }
        return returnValue;
    }

    /**
     * metode untuk menambahkan invoice ke list
     * @param  invoice                              objek invoice
     * @return                                      boolean
     * @throws OngoingInvoiceAlreadyExistsException jika invoice telah berstatus OnGoing
     */
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException
    {
        for(Invoice i: INVOICE_DATABASE)
        {
            if(i.getJobseeker() == invoice.getJobseeker() && i.getInvoiceStatus() == InvoiceStatus.OnGoing)
            {
                throw new OngoingInvoiceAlreadyExistsException(i);
            }
        }
        lastId = invoice.getId();
        return INVOICE_DATABASE.add(invoice);
    }

    /**
     * metode untuk mengubah invoice pada list
     * @param  id               id invoice yang ingin diganti
     * @param  invoiceStatus    objek status invoice
     * @return                  boolean
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus)
    {
        for(Invoice invoice: INVOICE_DATABASE)
        {
            if(invoice.getId() == id && invoice.getInvoiceStatus() == InvoiceStatus.OnGoing)
            {
                invoice.setInvoiceStatus(invoiceStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * metode untuk menghapus invoice dari list
     * @param  id                       id invoice
     * @return                          boolean
     * @throws InvoiceNotFoundException jika id tidak ditemukan dalam database bonus
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        if(INVOICE_DATABASE.removeIf(invoice -> (invoice.getId() == id)))
        {
            return true;
        }
        else {
            throw new InvoiceNotFoundException(id);
        }
    }
}

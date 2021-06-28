package MuhammadAsadMuyassir.jwork.threading;

import MuhammadAsadMuyassir.jwork.object.Invoice;

/**
 * Class FeeCalculator adalah class yang melakukan kalkulasi secara parallel
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class FeeCalculator implements Runnable {
    private Thread t;
    private Invoice invoice;

    /**
     * Constructor untuk objek dari class FeeCalculator
     * @param invoice objek invoice
     */
    FeeCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * Metode untuk menjalankan proses kalkulasi
     */
    public void run() {
        System.out.println("calculating invoice id: " +  invoice.getId());
        invoice.calculateTotalFee();
        System.out.println("finish calculating invoice id:" +  invoice.getId());
    }
}

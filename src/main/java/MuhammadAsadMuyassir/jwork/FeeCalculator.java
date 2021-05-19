package MuhammadAsadMuyassir.jwork;

/**
 * Class FeeCalculator adalah class yang melakukan kalkulasi secara parallel
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class FeeCalculator implements Runnable {
    private Thread t;
    private Invoice invoice;

    FeeCalculator(Invoice invoice) {
        this.invoice = invoice;
    }

    public void run() {
        System.out.println("calculating invoice id: " +  invoice.getId());
        invoice.setTotalFee();
        System.out.println("finish calculating invoice id:" +  invoice.getId());
    }
}

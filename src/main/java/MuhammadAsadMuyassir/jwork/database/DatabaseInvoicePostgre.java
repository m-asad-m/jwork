package MuhammadAsadMuyassir.jwork.database;

import MuhammadAsadMuyassir.jwork.object.*;
import MuhammadAsadMuyassir.jwork.enumeration.InvoiceStatus;
import MuhammadAsadMuyassir.jwork.exception.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class DatabaseInvoicePostgre adalah class yang melakukan seluruh query invoice
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
public class DatabaseInvoicePostgre {
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Metode untuk mendapatkan seluruh invoice yang ada pada database
     *
     * @return array list seluruh invoice
     */
    public static ArrayList<Invoice> getInvoice()
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Invoice> returnValue = new ArrayList<>();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM invoice NATURAL JOIN jobseeker NATURAL LEFT JOIN bonus;";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Invoice invoice = null;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("date"));
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(rs.getDate("join_date"));
                ArrayList<Job> jobs = DatabaseJobsPostgre.getJobsByInvoice(rs.getInt("invoice_id"));
                if(rs.getString("payment_type").equals("BankPayment")) {
                    invoice = new BankPayment(
                            rs.getInt("invoice_id"),
                            jobs,
                            new Jobseeker(
                                    rs.getInt("jobseeker_id"),
                                    rs.getString("name"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    calendar1
                            ),
                            rs.getInt("admin_fee"),
                            calendar
                    );
                } else {
                    invoice = new EwalletPayment(
                            rs.getInt("invoice_id"),
                            jobs,
                            new Jobseeker(
                                    rs.getInt("jobseeker_id"),
                                    rs.getString("name"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    calendar1
                            ),
                            new Bonus(
                                    rs.getInt("bonus_id"),
                                    rs.getString("referral_code"),
                                    rs.getInt("extra_fee"),
                                    rs.getInt("min_total_fee"),
                                    rs.getBoolean("active")
                            ),
                            calendar
                    );
                }
                invoice.setTotalFee(rs.getInt("total_fee"));
                invoice.setInvoiceStatus(InvoiceStatus.valueOf(rs.getString("invoice_status")));
                returnValue.add(invoice);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk mendapatkan invoice berdasarkan id
     *
     * @param id                        id invoice
     * @return                          objek invoice
     * @throws InvoiceNotFoundException jika id tidak ditemukan dalam database
     */
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            Invoice returnValue;
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM invoice NATURAL JOIN jobseeker NATURAL LEFT JOIN bonus WHERE invoice_id = %d;",
                    id
            );
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("date"));
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(rs.getDate("join_date"));
                ArrayList<Job> jobs = DatabaseJobsPostgre.getJobsByInvoice(rs.getInt("invoice_id"));
                if (rs.getString("payment_type").equals("BankPayment")) {
                    returnValue = new BankPayment(
                            rs.getInt("invoice_id"),
                            jobs,
                            new Jobseeker(
                                    rs.getInt("jobseeker_id"),
                                    rs.getString("name"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    calendar1
                            ),
                            rs.getInt("admin_fee"),
                            calendar
                    );
                } else {
                    returnValue = new EwalletPayment(
                            rs.getInt("invoice_id"),
                            jobs,
                            new Jobseeker(
                                    rs.getInt("jobseeker_id"),
                                    rs.getString("name"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    calendar1
                            ),
                            new Bonus(
                                    rs.getInt("bonus_id"),
                                    rs.getString("referral_code"),
                                    rs.getInt("extra_fee"),
                                    rs.getInt("min_total_fee"),
                                    rs.getBoolean("active")
                            ),
                            calendar
                    );
                }
                returnValue.setTotalFee(rs.getInt("total_fee"));
                returnValue.setInvoiceStatus(InvoiceStatus.valueOf(rs.getString("invoice_status")));
            } else {
                rs.close();
                stmt.close();
                conn.close();
                throw new InvoiceNotFoundException(id);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (InvoiceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk mendapatkan invoice berdasarkan id jobseeker
     *
     * @param id    id jobseeker
     * @return      array list invoice
     */
    public static ArrayList<Invoice> getInvoiceByJobseeker(int id)
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            ArrayList<Invoice> returnValue = new ArrayList<>();
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT * FROM invoice NATURAL JOIN jobseeker NATURAL LEFT JOIN bonus WHERE jobseeker_id = %d ORDER BY invoice_id DESC;",
                    id
            );
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                Invoice invoice = null;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(rs.getDate("date"));
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTime(rs.getDate("join_date"));
                ArrayList<Job> jobs = DatabaseJobsPostgre.getJobsByInvoice(rs.getInt("invoice_id"));
                if(rs.getString("payment_type").equals("BankPayment")) {
                    invoice = new BankPayment(
                            rs.getInt("invoice_id"),
                            jobs,
                            new Jobseeker(
                                    rs.getInt("jobseeker_id"),
                                    rs.getString("name"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    calendar1
                            ),
                            rs.getInt("admin_fee"),
                            calendar
                    );
                } else {
                    invoice = new EwalletPayment(
                            rs.getInt("invoice_id"),
                            jobs,
                            new Jobseeker(
                                    rs.getInt("jobseeker_id"),
                                    rs.getString("name"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    calendar1
                            ),
                            new Bonus(
                                    rs.getInt("bonus_id"),
                                    rs.getString("referral_code"),
                                    rs.getInt("extra_fee"),
                                    rs.getInt("min_total_fee"),
                                    rs.getBoolean("active")
                            ),
                            calendar
                    );
                }
                invoice.setTotalFee(rs.getInt("total_fee"));
                invoice.setInvoiceStatus(InvoiceStatus.valueOf(rs.getString("invoice_status")));
                returnValue.add(invoice);
            }
            rs.close();
            stmt.close();
            conn.close();
            return returnValue;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return null;
        }
    }

    /**
     * Metode untuk mengubah status invoice
     *
     * @param id                        id invoice
     * @param status                    enum status invoice
     * @return                          boolean status keberhasilan
     * @throws InvoiceNotFoundException jika id tidak ditemukan dalam database
     */
    public static boolean changeInvoiceStatus(int id, InvoiceStatus status) throws InvoiceNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "UPDATE invoice SET invoice_status = '%s' WHERE invoice_id = %d;",
                    status.name(),
                    id
            );
            int res = stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
            if(res == 0) {
                throw new InvoiceNotFoundException(id);
            } else {
                return true;
            }
        } catch (InvoiceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }

    /**
     * Metode untuk menghapus invoice dari database
     *
     * @param id                        id invoice
     * @return                          boolean status keberhasilan
     * @throws InvoiceNotFoundException jika id tidak ditemukan dalam database
     */
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "DELETE FROM jobs WHERE invoice_id = %d;",
                    id
            );
            int res = stmt.executeUpdate(sql);
            if(res == 0) {
                stmt.close();
                conn.close();
                throw new InvoiceNotFoundException(id);
            } else {
                try {
                    sql = String.format(
                            "DELETE FROM invoice WHERE invoice_id = %d;",
                            id
                    );
                    stmt.executeUpdate(sql);
                } catch (Exception ignored) {}
                stmt.close();
                conn.close();
                return true;
            }
        } catch (InvoiceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }

    /**
     * Metode untuk mengecek apakah terdapat invoice yang berstatus OnGoing
     *
     * @param jobseekerId                           id jobseeker
     * @throws OngoingInvoiceAlreadyExistsException jika terdapat invoice yang berstatus OnGoing
     */
    public static void checkOnGoingStatus(int jobseekerId)
            throws OngoingInvoiceAlreadyExistsException
    {
        conn = DatabaseConnectionPostgre.connection();
        try {
            stmt = conn.createStatement();
            String sql = String.format(
                    "SELECT invoice_id FROM invoice WHERE invoice_status = 'OnGoing' AND jobseeker_id = %d;",
                    jobseekerId
            );
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                rs.close();
                stmt.close();
                conn.close();
                throw new OngoingInvoiceAlreadyExistsException(jobseekerId);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (OngoingInvoiceAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
        }
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
    public static boolean addBankPayment(ArrayList<Integer> jobIdList, int jobseekerId, int adminFee)
            throws OngoingInvoiceAlreadyExistsException, JobNotFoundException
    {
        checkOnGoingStatus(jobseekerId);
        BankPayment bankPayment = new BankPayment(0, DatabaseJobsPostgre.getJobsByJobId(jobIdList), null, adminFee);
        bankPayment.calculateTotalFee();

        conn = DatabaseConnectionPostgre.connection();
        String sql;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            sql = String.format(
                    "INSERT INTO invoice (date, total_fee, invoice_status, payment_type, admin_fee, jobseeker_id) VALUES ('%s', %d, '%s', '%s', %d, %d) RETURNING invoice_id;",
                    bankPayment.getDate().getTime(),
                    bankPayment.getTotalFee(),
                    bankPayment.getInvoiceStatus().name(),
                    bankPayment.getPaymentType().name(),
                    bankPayment.getAdminFee(),
                    jobseekerId
            );
            rs = stmt.executeQuery(sql);
            rs.next();
            int invoiceId = rs.getInt("invoice_id");
            if(!DatabaseJobsPostgre.addJobs(invoiceId, jobIdList)) {
                removeInvoice(invoiceId);
                return false;
            }
            rs.close();
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
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
    public static boolean addEwalletPayment(ArrayList<Integer> jobIdList, int jobseekerId, String referralCode)
            throws OngoingInvoiceAlreadyExistsException, JobNotFoundException
    {
        checkOnGoingStatus(jobseekerId);
        EwalletPayment ewalletPayment = new EwalletPayment(0, DatabaseJobsPostgre.getJobsByJobId(jobIdList), null);

        conn = DatabaseConnectionPostgre.connection();
        String sql;
        ResultSet rs;
        try {
            stmt = conn.createStatement();
            try {
                ewalletPayment.setBonus(DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
                ewalletPayment.calculateTotalFee();
                sql = String.format(
                        "INSERT INTO invoice (date, total_fee, invoice_status, payment_type, bonus_id, jobseeker_id) VALUES ('%s', %d, '%s', '%s', %d, %d) RETURNING invoice_id;",
                        ewalletPayment.getDate().getTime(),
                        ewalletPayment.getTotalFee(),
                        ewalletPayment.getInvoiceStatus().name(),
                        ewalletPayment.getPaymentType().name(),
                        ewalletPayment.getBonus().getId(),
                        jobseekerId
                );
            } catch (BonusNotFoundException e) {
                System.out.println(e.getMessage());
                ewalletPayment.calculateTotalFee();
                sql = String.format(
                        "INSERT INTO invoice (date, total_fee, invoice_status, payment_type, jobseeker_id) VALUES ('%s', %d, '%s', '%s', %d) RETURNING invoice_id;",
                        ewalletPayment.getDate().getTime(),
                        ewalletPayment.getTotalFee(),
                        ewalletPayment.getInvoiceStatus().name(),
                        ewalletPayment.getPaymentType().name(),
                        jobseekerId
                );
            }
            rs = stmt.executeQuery(sql);
            rs.next();
            int invoiceId = rs.getInt("invoice_id");
            if(!DatabaseJobsPostgre.addJobs(invoiceId, jobIdList)) {
                removeInvoice(invoiceId);
                return false;
            }
            rs.close();
            stmt.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage());
            return false;
        }
    }
}

package MuhammadAsadMuyassir.jwork.object;

/**
 * Class Bonus adalah class yang menyimpan data bonus
 *
 * @author Muhammad As'ad Muyassir
 * @version 01-04-2021
 */
public class Bonus
{
    private int id;
    private String referralCode;
    private int extraFee;
    private int minTotalFee;
    private boolean active;

    /**
     * Constructor untuk objek dari class Bonus
     *
     * @param id           id bonus
     * @param referralCode kode referral
     * @param extraFee     tambahan fee
     * @param minTotalFee  total fee minimal
     * @param active       status aktif
     */
    public Bonus(int id, String referralCode, int extraFee, int minTotalFee, boolean active)
    {
        this.id = id;
        this.referralCode = referralCode;
        this.extraFee = extraFee;
        this.minTotalFee = minTotalFee;
        this.active = active;
    }

    /**
     * Metode untuk mendapatkan id bonus
     *
     * @return id bonus
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Metode untuk mendapatkan kode referral
     *
     * @return kode referral
     */
    public String getReferralCode()
    {
        return referralCode;
    }
    
    /**
     * Metode untuk mendapatkan tambahan fee
     *
     * @return tambahan fee
     */
    public int getExtraFee()
    {
        return extraFee;
    }
    
    /**
     * Metode untuk mendapatkan total fee minimal
     *
     * @return total fee minimal
     */
    public int getMinTotalFee()
    {
        return minTotalFee;
    }
    
    /**
     * Metode untuk mendapatkan status aktif
     *
     * @return status aktif
     */
    public boolean getActive()
    {
        return active;
    }
    
    /**
     * Metode untuk mengubah id bonus
     *
     * @param id id bonus
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Metode untuk mengubah kode referral
     *
     * @param referralCode kode referral
     */
    public void setReferralCode(String referralCode)
    {
        this.referralCode = referralCode;
    }
    
    /**
     * Metode untuk mengubah tambahan fee
     *
     * @param extraFee tambahan fee
     */
    public void setExtraFee(int extraFee)
    {
        this.extraFee = extraFee;
    }
    
    /**
     * Metode untuk mengubah total fee minimal
     *
     * @param minTotalFee total fee minimal
     */
    public void setMinTotalFee(int minTotalFee)
    {
        this.minTotalFee = minTotalFee;
    }
    
    /**
     * Metode untuk mengubah status aktif
     *
     * @param active status aktif
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    /** Metode untuk mendapatkan objek Bonus dalam bentuk string */
    public String toString()
    {
        String returnValue = "===================== BONUS =====================" + "\n" +
                             "ID = " + id + "\n" +
                             "Referral Code = " + referralCode + "\n" +
                             "Extra Fee = " + extraFee + "\n" +
                             "Min TotalFee = " + minTotalFee + "\n" +
                             "Active status = " + active + "\n";
        return returnValue;
    }
}

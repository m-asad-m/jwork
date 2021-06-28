package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.object.Bonus;
import MuhammadAsadMuyassir.jwork.exception.BonusNotFoundException;
import MuhammadAsadMuyassir.jwork.exception.ReferralCodeAlreadyExistsException;
import MuhammadAsadMuyassir.jwork.database.DatabaseBonusPostgre;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Class BonusController adalah class yang menghandle seluruh request bonus
 *
 * @author Muhammad As'ad Muyassir
 * @version 27-06-2021
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {

    /**
     * Metode untuk mendapatkan seluruh bonus yang ada pada database
     *
     * @return array list seluruh bonus
     */
    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus()
    {
        return DatabaseBonusPostgre.getBonus();
    }

    /**
     * Metode untuk mendapatkan bonus berdasarkan id
     *
     * @param id                        id bonus
     * @return                          objek bonus
     * @throws BonusNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping("/{id}")
    public Bonus getBonusById(@PathVariable int id)
            throws BonusNotFoundException
    {
        return DatabaseBonusPostgre.getBonusById(id);
    }

    /**
     * Metode untuk mendapatkan bonus berdasarkan kode referral
     *
     * @param referralCode              kode referral
     * @return                          objek bonus
     * @throws BonusNotFoundException   jika kode referral tidak ditemukan dalam database
     */
    @RequestMapping("/ref/{referralCode}")
    public Bonus getBonusByReferralCode(@PathVariable String referralCode)
            throws BonusNotFoundException
    {
        return DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
    }

    /**
     * Metode untuk menambahkan bonus ke dalam database
     *
     * @param referralCode                          kode referral
     * @param extraFee                              bayaran tambahan
     * @param minTotalFee                           total bayaran minimal
     * @param active                                status aktif
     * @return                                      boolean status keberhasilan
     * @throws ReferralCodeAlreadyExistsException   jika kode referral sudah terdapat dalam database
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public boolean addBonus(@RequestParam(value="referralCode") String referralCode,
                            @RequestParam(value="extraFee") int extraFee,
                            @RequestParam(value="minTotalFee") int minTotalFee,
                            @RequestParam(value="active") boolean active)
            throws ReferralCodeAlreadyExistsException
    {
        return DatabaseBonusPostgre.addBonus(new Bonus(0, referralCode, extraFee, minTotalFee, active));
    }

    /**
     * Metode untuk mengubah status aktif bonus
     *
     * @param id                        id bonus
     * @param status                    status aktif
     * @return                          boolean status keberhasilan
     * @throws BonusNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/setBonusStatus/{id}", method = RequestMethod.PUT)
    public boolean setBonusStatus(@PathVariable int id,
                                  @RequestParam(value="status") boolean status)
            throws BonusNotFoundException
    {
        return DatabaseBonusPostgre.setBonusStatus(id, status);
    }

    /**
     * Metode untuk menghapus bonus dari database
     *
     * @param id                        id bonus
     * @return                          boolean status keberhasilan
     * @throws BonusNotFoundException   jika id tidak ditemukan dalam database
     */
    @RequestMapping(value = "/removeBonus/{id}", method = RequestMethod.DELETE)
    public boolean removeBonus(@PathVariable int id)
            throws BonusNotFoundException
    {
        return DatabaseBonusPostgre.removeBonus(id);
    }
}

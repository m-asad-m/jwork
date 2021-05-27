package MuhammadAsadMuyassir.jwork.controller;

import MuhammadAsadMuyassir.jwork.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/bonus")
@RestController
public class BonusController {

    @RequestMapping("")
    public ArrayList<Bonus> getAllBonus() {
        return DatabaseBonus.getBonusDatabase();
    }

    @RequestMapping("/{referralCode}")
    public Bonus getBonusByReferralCode(@PathVariable String referralCode) {
        return DatabaseBonus.getBonusByReferralCode(referralCode);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(@RequestParam(value="referralCode") String referralCode,
                          @RequestParam(value="extraFee") int extraFee,
                          @RequestParam(value="minTotalFee") int minTotalFee,
                          @RequestParam(value="active") boolean active)
    {
        Bonus bonus = new Bonus(DatabaseBonus.getLastId()+1, referralCode, extraFee, minTotalFee, active);
        try {
            DatabaseBonus.addBonus(bonus);
        } catch (ReferralCodeAlreadyExistsException e) {
            e.getMessage();
            return null;
        }
        return bonus;
    }
}

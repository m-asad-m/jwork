/**
 * Class BonusNotFoundException adalah class yang melakukan penanganan kesalahan
 *
 * @author Muhammad As'ad Muyassir
 * @version 06-05-2021
 */

public class BonusNotFoundException extends Exception {
    private int bonus_error;

    /**
     * Constructor untuk objek dari class BonusNotFoundException
     * @param bonus_input id bonus
     */
    public BonusNotFoundException(int bonus_input)
    {
        super("Bonus ID: ");
        bonus_error = bonus_input;
    }

    /**
     * metode untuk mendapatkan pesan error
     * @return pesan error
     */
    public String getMessage()
    {
        return super.getMessage() + bonus_error + " not found";
    }
}

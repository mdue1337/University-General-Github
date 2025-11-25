/**
 * @author Martin Due & Mathias Bøttger
 * @version 22/11-2025
 */

import java.util.Random;

public class CapitalCity extends BorderCity {
    /**
     * Creates a border city — see {@link BorderCity#BorderCity(String,int,Country)} for details.
     */
    public CapitalCity(String name, int value, Country country) {
        super(name, value, country);
    }

    /**
     * Calculates bonus.
     * Subtracts toll, if applicable
     * Subtracts calculated expenses which are in between 1 and players current money + the bonus minus toll
     * @param p player
     * @return calculated bonus minus toll and expenses
     */
    @Override
    public int arrive(Player p){
        int bonus = super.arrive(p);

        int expenses = p.getCountry().getGame().getRandom().nextInt(p.getMoney() + 1 + bonus);
        changeValue(expenses);

        return bonus - expenses;
    }
}

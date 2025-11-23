/**
 * @author Martin Due & Mathias Bøttger
 * @version 22/11-2025
 */

import java.util.Random;

public class CapitalCity extends BorderCity {
    public CapitalCity(String name, int value, Country country) {
        super(name, value, country);
    }

    @Override
    public int arrive(Player p){
        int bonus = super.arrive(p);

        Random rng = p.getCountry().getGame().getRandom();
        int expenses = rng.nextInt(0, p.getMoney() + 1);
        p.setMoney(p.getMoney() - expenses);
        changeValue(expenses);

        return bonus - expenses;
    }
}

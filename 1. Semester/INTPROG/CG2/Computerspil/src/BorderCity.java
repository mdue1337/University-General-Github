/**
 * @author Martin Due & Mathias Bøttger
 * @version 18/11-2025
 */

public class BorderCity extends City {
    /**
     * Creates a border city — see {@link City#City(String,int,Country)} for details.
     */
    public BorderCity(String name, int value, Country country) {
        super(name, value, country);
    }

    /**
     * If same country, super.arrive() is returned.
     * Otherwise a toll is calculated and bonus minus toll is returned
     * @param p player
     * @return calculated bonus
     */
    @Override
    public int arrive (Player p) {
        int bonus = super.arrive();

        if(!getCountry().equals(p.getFromCountry())){
            int toll = (p.getMoney() * getCountry().getGame().getSettings().getTollToBePaid()) / 100;
            changeValue(toll);

            return bonus - toll;
        }

        return bonus;
    }
}
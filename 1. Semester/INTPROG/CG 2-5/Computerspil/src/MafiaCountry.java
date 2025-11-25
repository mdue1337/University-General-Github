/**
 * @author Martin Due & Mathias Bøttger
 * @version 22/11-2025
 */

public class MafiaCountry extends Country{

    /**
     * Creates an empty mafia country
     *
     * @param name       the name of the country (non\-null)
     * @return The country object
     */
    MafiaCountry(String name) {
        super(name);
    }

    /**
     * Calculates the bonus the player will recieve.
     * If the player is unlucky, they will get stolen from - by the mafia, the returned bonus is negative.
     * If that isn't the case and the provided value is greater than 0, the player will recieve a random bonus between 0 and the provided value inclusive.
     * Else 0 is returned.
     * @param value The upper bound for the random returned bonus.
     * @return the calculated bonus.
     */
    @Override
    public int bonus(int value) {
        int risk = getGame().getSettings().getRisk();

        if (getGame().getRandom().nextInt(100) >= risk) {
            return super.bonus(value);
        }

        return - getGame().getLoss();
    }
}

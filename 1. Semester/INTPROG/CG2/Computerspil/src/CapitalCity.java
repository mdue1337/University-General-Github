import java.util.Random;

public class CapitalCity extends BorderCity {
    public CapitalCity(String name, int value, Country country) {
        super(name, value, country);
    }

    @Override
    public int arrive(Player p){
        Random rng = p.getCountry().getGame().getRandom();
        int expenses = rng.nextInt(0, p.getMoney() + 1);
        return super.arrive() - expenses;
    }
}

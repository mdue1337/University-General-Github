/**
 * @author Martin Due & Mathias Bøttger
 * @version 02/12-2025
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Log implements Serializable {
    private int seed;
    private Settings settings;
    private Map<Integer, String> choices;

    public Log(int seed, Settings settings) {
        this.settings = settings;
        this.seed = seed;
        choices = new HashMap<>();
    }

    /**
     * @return log seed
     */
    public int getSeed() {
        return seed;
    }

    /**
     * @return log settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * @param step
     * @return city for step OR null
     */
    public String getChoice(int step) {
        return choices.getOrDefault(step, null);
    }

    /**
     * Adds a move to the log
     * @param step
     * @param city
     */
    public void add(int step, City city){
        choices.put(step, city.getName());
    }
}

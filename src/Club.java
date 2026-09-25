import java.util.Random;

/**
 * This class Represents an encounter with
 * a club booth and its members
 * 
 * @author Aleysa Sweeney
 * @version 2026.09.24
 */

public class Club extends Person {
    private int numberOfPeople;
    private boolean hasEnergyDrinks;

    /**
     * creates a new club encounter. randomly determines
     * the num of club members and whether
     * the club is giving out energy
     * drinks. replaces default
     * person choice with club specific options
     */
    public Club() {
        super();
        Random rand = new Random();
        this.numberOfPeople = rand.nextInt(10) + 1;
        this.hasEnergyDrinks = rand.nextBoolean();

        int distanceReduction = 0;
        // energy drinks provide distance boost
        if (this.hasEnergyDrinks) {
            distanceReduction = 3;

        }
        // replace default person conversation choice
        Choice talk = new Choice("Talk to club members", "You stop and talk to "
                + this.numberOfPeople + " club members.", this.numberOfPeople,
                distanceReduction);

        this.choices.set(0, talk);
    }

}

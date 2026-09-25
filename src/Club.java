import java.util.Random;

/**
 * This class represents an encounter with
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
        Choice talk;

        // energy drinks provide distance boost
        if (this.hasEnergyDrinks) {
            // replace default person conversation choice
            talk = new Choice("Talk to club members at a booth", "You stop and talk to "
                    + this.numberOfPeople + " club members for " + this.numberOfPeople
                    + " minutes. They gave you a free energy drink which allowed you to quickly travel 0.3 miles.",
                    this.numberOfPeople, 3, 2);
        } else {
            // replace default person conversation choice
            talk = new Choice("Talk to club members at a booth", "You stop and talk to "
                    + this.numberOfPeople + " club members for " + this.numberOfPeople
                    + " minutes and do not travel anywhere.", this.numberOfPeople,
                    0, 1);
        }

        this.choices.set(0, talk);
    }

}

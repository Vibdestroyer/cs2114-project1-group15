import java.util.Random;

/**
 * Represents a restaurant encounter with randomized waiting times.
 */
public class Restaurant extends Encounter {
    private boolean takesOnlineOrders;
    private boolean grabAndGo;

    /**
     * Creates a new Restaurant encounter.
     */
    public Restaurant() {
        super();

        Random rand = new Random();

        this.takesOnlineOrders = rand.nextBoolean();
        this.grabAndGo = rand.nextBoolean();

        String resultText = "You grab your food and continue rushing to class.";

        // Base time cost is 10 minutes
        int timeChange = 10;

        if (this.takesOnlineOrders) {
            timeChange -= 4;
            resultText += " The restaurant takes online orders which saved time.";
        }

        if (this.grabAndGo) {
            timeChange -= 4;
            resultText += " The restaurant served grab and go food which saved time.";
        }

        int distanceChange = 3;

        Choice getFood = new Choice("Get food from restaurant",
                resultText + " This took " + timeChange + " minutes and gave you the energy to travel 0.3 miles.",
                timeChange, distanceChange, 2);

        this.choices.add(getFood);
    }
}

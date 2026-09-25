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

        // Base time cost is 10 minutes
        int timeChange = 10;

        if (this.takesOnlineOrders) {
            timeChange -= 4;
        }

        if (this.grabAndGo) {
            timeChange -= 4;
        }

        int distanceChange = 3;

        String resultText = "You grab your food and continue rushing to class.";

        Choice getFood = new Choice("Get food from restaurant", resultText,
                timeChange, distanceChange);

        this.choices.add(getFood);
    }
}

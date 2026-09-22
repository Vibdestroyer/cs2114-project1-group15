import java.util.Random;

public class Restaurant extends Encounter {
    private boolean takesOnlineOrders;
    private boolean grabAndGo;

    /**
     * Creates a new Restaurant encounter with randomized service speeds
     * and sets up the corresponding choice.
     */
    public Restaurant() {
        super("You pass by a campus dining center smelling delicious food.");
        
        Random rand = new Random();

        // Randomly assigns grab and go availability and online orders.
        this.takesOnlineOrders = rand.nextBoolean();
        this.grabAndGo = rand.nextBoolean();

        // Base time cost is 10 minutes.
        int timeChange = 10;

        // Reduces the time cost by 4 if online orders are available.
        if (this.takesOnlineOrders) {
            timeChange -= 4;
        }

        // Reduces time cost by 4 if the food can be eaten on the walk.
        if (this.grabAndGo) {
            timeChange -= 4;
        }
        
        int distanceChange = 3;

        // Result text displayed after the player picks this option
        String resultText = "You grab your food and continue rushing to class.";

        // Construct Choice with all 4 parameters: menuText, resultText, timeCost, distanceReduction
        Choice getFood = new Choice(
            "Get food from restaurant",
            resultText,
            timeChange,
            distanceChange
        );

        this.addChoice(getFood);
    }

    /**
     * @return Whether online orders are accepted.
     */
    public boolean getTakesOnlineOrders() {
        return takesOnlineOrders;
    }

    /**
     * @return Whether grab-and-go is available.
     */
    public boolean isGrabAndGo() {
        return grabAndGo;
    }
}

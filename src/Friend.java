import java.util.Random;

/**
 * This class represents the user
 * encountering with a friend with
 * randomized food and car
 * 
 * @author Aleysa Sweeney
 * @version 2026.09.24
 * 
 */
public class Friend extends Person {
    private boolean haveFood;
    private boolean haveCar;

    /**
     * creates new friend encounter,
     * replaces default person choice with
     * friend specific options and also adds
     * choices for food and transportation
     * 
     * 
     */
    public Friend() {
        super();

        Random rand = new Random();

        this.haveFood = rand.nextBoolean();
        this.haveCar = rand.nextBoolean();

        // choice to talk to friend
        Choice talk = new Choice("Talk to your friend " + getName(),
                "You stop and talk to your friend " + getName() + ".", 5, 0);

        this.choices.set(0, talk);

        // snack option if friend has food
        if (this.haveFood) {
            Choice food = new Choice("Take a snack from " + getName(),
                    "Your friend gives you a snack which gives you an energy boost.",
                    5, 5);

            this.choices.add(food);
        }

        // ride option if friend has a car
        if (this.haveCar) {
            Choice car = new Choice("Get a ride to class",
                    "Your friend drives you and drops you off outside your class building",
                    5, 10);

            this.choices.add(car);
        }
    }
}

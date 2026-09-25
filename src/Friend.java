import java.util.Random;

/**
 * This class represents the user's encounter with a friend who may
 * have food or a car.
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
     * friend-specific options and also adds
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
                "You stop and talk to your friend " + getName() + " for 5 minutes and do not travel at all.", 5, 0, 1);

        this.choices.set(0, talk);

        // snack option if friend has food
        if (this.haveFood) {
            Choice food = new Choice("Take a snack from your friend " + getName(),
                    "Your friend gives you a snack which gives you an energy boost. With this energy, you traveled 0.5 miles in 5 minutes.",
                    5, 5, 2);

            this.choices.add(food);
        }

        // ride option if friend has a car
        if (this.haveCar) {
            Choice car = new Choice("Get a ride to class from your friend " + getName(),
                    "Your friend drives you and drops you off outside your class building. In 5 minutes, you travel 1 mile.",
                    5, 10, 2);

            this.choices.add(car);
        }
    }
}

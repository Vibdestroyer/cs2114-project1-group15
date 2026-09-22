import java.util.Random;
import src.Choice;
import src.Person;

/**
 * This class represents the user
 * encountering with a friend with
 * randomized food and car
 * 
 */
public class Friend extends Person {
    private boolean haveFood;
    private boolean haveCar;

    public Friend(String Person) {
        super();

        Random rand = new Random();

        this.haveFood = rand.nextBoolean();
        this.haveCar = rand.nextBoolean();

        this.choices.clear();

        Choice talk = new Choice("Talk to your friend" + getName(),
            "You stop and talk to your friend" + getName() + ".", -5, 0);

        this.choices.add(talk);

        if (this.haveFood) {

            Choice food = new Choice("Take a snack",
                "Your friend gives you a snack which gives you an energu boost.",
                -5, -5);

            this.choices.add(food);

        }

        if (this.haveCar) {
            Choice car = new Choice("Get a ride to class",
                "Your friend drives you and drops you off outside your class building",
                -5, -10);

            this.choices.add(car);
        }

    }

}

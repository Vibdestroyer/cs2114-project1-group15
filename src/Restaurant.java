import java.util.Random;
public class Restaurant extends Encounter {
  private boolean takesOnlineOrders;
  private boolean grabAndGo;

  public Restaurant() {
    super();
    Random rand = new Random();

    // Randomly assigns grab and go availability and online orders.
    this.takesOnlineOrders = rand.nextBoolean();
    this.grabAndGo = rand.nextBoolean();

    // The time cost is 10 minutes. 
    int timeChange = -10;

    // Reduces the time cost by 4 if they choose online orders.
    if (this.takesOnlineOrders) {
      timeChange += 4;
    }

    // Reduces time cost by 4 if the food can be eaten on the walk.
    if (this.grabAndGo) {
      timeChange += 4;
    }
    int distanceChange = -3;

    // Add the choice to the encounter's list of choices.
    Choice getFood = new Choice("Get food from restaurant", timeChange, distanceChange);
    this.choices.add(getFood);
  }
}



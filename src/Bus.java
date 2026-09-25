import java.util.Random;

public class Bus extends Encounter {

    private int peopleOnBoard;
    private int maxCapacity;
    private int rideTime;

    public Bus() {
        super();

        Random rand = new Random();

        this.peopleOnBoard = rand.nextInt(120) + 1;
        this.maxCapacity = 100;
        this.rideTime = rand.nextInt(6) + 5;

        if (this.peopleOnBoard >= this.maxCapacity) {

            Choice waitForBus = new Choice("Try taking the bus",
                    "The bus is full. You wait 2 minutes and do not travel at all.", 2, 0, -2);

            this.choices.add(waitForBus);
        } else {

            // There is room on the bus.
            Choice takeBus = new Choice("Try taking the bus", "You find a seat! You ride the bus for "
                    + this.rideTime + " minutes and travel 0.7 miles.", this.rideTime, 7, 2);

            this.choices.add(takeBus);
        }
    }
}

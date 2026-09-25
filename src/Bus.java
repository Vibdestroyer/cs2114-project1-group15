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

            Choice waitForBus = new Choice("Wait for another bus",
                "The bus is full. You wait 2 minutes.", 2, 0);

            this.choices.add(waitForBus);
        }
        else {

            // There is room on the bus.
            Choice takeBus = new Choice("Take the bus", "You ride the bus for "
                + this.rideTime + " minutes.", this.rideTime, 7);

            this.choices.add(takeBus);
        }
    }
}

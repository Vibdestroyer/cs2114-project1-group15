import java.util.List;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

/**
 * This class represents the user's encounter with a general person encountered
 * while traveling to class.
 * 
 * @author Victor Braday
 * @version 2026.09.22
 * 
 */
public class Person extends Encounter {

    private List<String> names;
    protected String name;

    /**
     * Creates a new Person encounter.
     */
    public Person() {
        super();

        try {
            names = Files.readAllLines(Paths.get("src/names.txt"));
        }
        catch (IOException e) {
            throw new IllegalStateException("Could not read names.txt", e);
        }
        Random rand = new Random();
        int index = rand.nextInt(names.size());
        this.name = names.get(index);

        int timeChange = 5;
        int distanceChange = 0;

        Choice talk = new Choice("Talk to " + this.name, "You stop and talk to "
            + this.name + " for 5 minutes and do not travel at all.",
            timeChange, distanceChange, 1);

        this.choices.add(talk);
    }
}

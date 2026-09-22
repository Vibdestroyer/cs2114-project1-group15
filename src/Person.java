
import java.util.List;
import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Person extends Encounter {

    private List<String> names;
    private String name;

    public Person() {
        super();

        try {
            names = Files.readAllLines(Paths.get("names.txt"));
        } catch (IOException e) {
            throw new IllegalStateException(
                    "Could not read names.txt", e);
        }
        Random rand = new Random();
        int index = rand.nextInt(names.size());
        this.name = names.get(index);

        int timeChange = -5;
        int distanceChange = 0;

        Choice talk = new Choice(
                "Talk to " + this.name,
                "You stop and talk to " + this.name + ".",
                timeChange,
                distanceChange);

        this.choices.add(talk);
    }

    public String getName() {
        return this.name;
    }
}
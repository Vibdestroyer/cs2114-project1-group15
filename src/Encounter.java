import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class representing a campus encounter that provides
 * choices for the player.
 */
public abstract class Encounter {

    /**
     * Stores choices for this encounter.
     */
    protected List<Choice> choices;

    /**
     * Initializes an empty list of choices.
     */
    protected Encounter() {
        this.choices = new ArrayList<>();
    }

    /**
     * Returns the list of choices for this encounter.
     *
     * @return List of choices.
     */
    public List<Choice> getChoices() {
        return this.choices;
    }

    /**
     * Adds a choice to this encounter.
     *
     * @param choice
     *               Choice to add.
     */
    public void addChoice(Choice choice) {
        if (choice != null) {
            this.choices.add(choice);
        }
    }
}

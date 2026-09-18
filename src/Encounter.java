import java.util.ArrayList;
import java.util.List;
/**
* Abstract class for a player to encounter and includes all encounter types
* to provide the choices, which the main class will display. 
*/
public abstract class Encounter {

    /**
    * Stores all the choices that are associated with a particular
    * Encounter, so the program can display them to the player.
    * The subclasses can access and modify this list. 
    */
    protected List<Choice> choices;

    /**
    * Constructor for the class that initializes the empty list of choices
    * for the encounter, restricted to the subclasses so they can initialize 
    * list while preventing external classes from accessing it and creating
    * instances. 
    */
    protected Encounter() {
        this.choices = new ArrayList<>();
    }

    /**
    * Returns the list of available choices for a specific encounter.
    * Other classes can retrieve the choices without modifying the 
    * underlying variable directly.
    */
    public List<Choice> getChoices() {
        return this.choices;
    }
}

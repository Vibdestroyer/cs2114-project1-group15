public class Freshman extends Person {

    /**
     * This class represents an encounter with a freshman
     * 
     * @author Aleysa Sweeney
     * @version 2026.09.24
     */

    /**
     * creates a new freshman encounter + replaces default
     * person choice with freshman specific
     * conversation options.
     */
    public Freshman() {
        super();
        // replaces default person choice
        Choice talk = new Choice("Talk to Freshman " + this.getName(),
            "You stop and talk to the freshman " + this.getName(), -5, 0);
        this.choices.set(0, talk);

        // option to help freshman
        Choice directions = new Choice(

            "Give directions", "You helped the freshman find their class", -10,
            0);

        this.choices.add(directions);

    }
}

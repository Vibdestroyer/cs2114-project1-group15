/**
 * This class represents an encounter with a freshman
 * 
 * @author Aleysa Sweeney
 * @version 2026.09.24
 */
public class Freshman extends Person {
        /**
         * creates a new freshman encounter + replaces default
         * person choice with freshman specific
         * conversation options.
         */
        public Freshman() {
                super();
                // replaces default person choice
                Choice talk = new Choice("Talk to a freshman named " + name,
                        "You stop and talk to " + name
                                + " for 5 minutes and do not travel at all.", 5,
                        0, 1);
                this.choices.set(0, talk);

                // option to help freshman
                Choice directions = new Choice(
                        "Give directions to a lost freshman", "You helped the "
                                + name
                                + " find their class which took 10 minutes and you did not travel at all.",
                        10, 0, 2);

                this.choices.add(directions);

        }
}

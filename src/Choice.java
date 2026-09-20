/**
 * Choice is used to represent an option that the user can take
 * Each choice object has menuText (string), resultText (string),
 * timeCost (int), and distanceReduction (int).
 *
 * @author Sarah Gage
 * @version 2026.09.18
 */

public class Choice {
    private String menuText;
    private String resultText;
    private int timeCost;
    private int distanceReduction;

    // ----------------------------------------------------------
    /**
     * Create a new Choice object.
     * 
     * @param menuText
     *            The text to be displayed as the option in the menu.
     * @param resultText
     *            The text to be displayed after the option was selected.
     * @param timeCost
     *            The amount of time that the option will take.
     * @param distanceReduction
     *            The distance that will be covered by taking this option.
     */
    public Choice(
        String menuText,
        String resultText,
        int timeCost,
        int distanceReduction) {
        this.menuText = menuText;
        this.resultText = resultText;
        this.timeCost = timeCost;
        this.distanceReduction = distanceReduction;
    }


    // ----------------------------------------------------------
    /**
     * The text to be displayed in the menu.
     * 
     * @return Returns the menu text.
     */
    public String getMenuText() {
        return menuText;
    }


    // ----------------------------------------------------------
    /**
     * The text to be displayed after the option was chosen.
     * 
     * @return Returns the resulting text.
     */
    public String getResultText() {
        return resultText;
    }


    // ----------------------------------------------------------
    /**
     * The amount of time an option takes.
     * 
     * @return Returns the option's time cost.
     */
    public int getTimeCost() {
        return timeCost;
    }


    // ----------------------------------------------------------
    /**
     * The amount of distance an option will cover.
     * 
     * @return Returns the distance reduction by the option.
     */
    public int getDistanceReduction() {
        return distanceReduction;
    }


    // ----------------------------------------------------------
    /**
     * Determines if two objects are equal. Two choices are equal if they have
     * the menu text, result text, time cost, and distance reduction.
     *
     * @return Returns true if objects are equal.
     * @param other
     *            The object to compare this to.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass() == other.getClass()) {
            Choice choice2 = (Choice)other;
            return (this.getMenuText().equals(choice2.getMenuText()) && this
                .getResultText().equals(choice2.getResultText()) && this
                    .getTimeCost() == choice2.getTimeCost() && this
                        .getDistanceReduction() == choice2
                            .getDistanceReduction());
        }
        else {
            return false;
        }
    }
}

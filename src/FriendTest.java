import java.util.List;
import student.TestCase;

/**
 * Test class for Friend class
 *
 * @author Aleysa Sweeney
 * @version 2026.09.24
 */
public class FriendTest extends TestCase {

    /**
     * tests that the friend encounter is initialized correctly
     */
    public void testInitialization() {

        Friend f = new Friend("Person");

        List<Choice> choices = f.getChoices();

        assertNotNull(choices);
        assertTrue(choices.size() >= 1);
        assertTrue(choices.size() <= 3);

        Choice talk = choices.get(0);

        assertTrue(talk.getMenuText().contains("friend"));
        assertEquals(-5, talk.getTimeCost());
        assertEquals(0, talk.getDistanceReduction());
    }


    /**
     * tests that all possible random outcomes occur
     */
    public void testRandomChoicesAppear() {

        boolean sawFood = false;
        boolean sawCar = false;
        boolean sawOnlyTalk = false;

        for (int i = 0; i < 100; i++) {

            Friend f = new Friend("Person");

            List<Choice> choices = f.getChoices();
            if (choices.size() == 1) {
                sawOnlyTalk = true;
            }
            for (Choice choice : choices) {
                if (choice.getMenuText().equals("Take a snack")) {
                    sawFood = true;
                }
                if (choice.getMenuText().equals("Get a ride to class")) {
                    sawCar = true;
                }
            }
        }
        assertTrue(sawFood);
        assertTrue(sawCar);
        assertTrue(sawOnlyTalk);
    }


    /**
     * tests the values of the optional choices.
     */
    public void testChoiceValues() {
        for (int i = 0; i < 100; i++) {
            Friend f = new Friend("Person");
            List<Choice> choices = f.getChoices();

            for (Choice choice : choices) {
                if (choice.getMenuText().equals("Take a snack")) {
                    assertEquals(-5, choice.getTimeCost());
                    assertEquals(-5, choice.getDistanceReduction());
                }

                if (choice.getMenuText().equals("Get a ride to class")) {
                    assertEquals(-5, choice.getTimeCost());
                    assertEquals(-10, choice.getDistanceReduction());
                }
            }
        }
    }
}

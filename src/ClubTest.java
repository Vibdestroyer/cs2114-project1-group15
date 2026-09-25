import java.util.List;
import student.TestCase;

/**
 * Tests class for Club class
 *
 * @author Aleysa Sweeney
 * @version 2026.09.24
 */
public class ClubTest extends TestCase {

    /**
     * tests that the club encounter is initialized correctly
     */
    public void testInitialization() {
        Club c = new Club();

        List<Choice> choices = c.getChoices();

        assertNotNull(choices);
        assertEquals(1, choices.size());

        Choice talk = choices.get(0);
        assertEquals("Talk to club members", talk.getMenuText());
        assertTrue(talk.getResultText().contains("club members"));
    }


    /**
     * tests that the randomized values stay within
     * their expected ranges.
     */
    public void testRandomValues() {
        for (int i = 0; i < 100; i++) {

            Club c = new Club();
            Choice talk = c.getChoices().get(0);

            assertTrue(talk.getTimeCost() <= -1);
            assertTrue(talk.getTimeCost() >= -10);
            assertTrue(talk.getDistanceReduction() == 0 || talk
                .getDistanceReduction() == 3);
        }
    }


    /**
     * tests that both energy drink outcomes occur
     */
    public void testEnergyDrinkBranches() {
        boolean sawEnergyDrinks = false;
        boolean sawNoEnergyDrinks = false;
        for (int i = 0; i < 100; i++) {

            Club c = new Club();
            Choice talk = c.getChoices().get(0);
            if (talk.getDistanceReduction() == 3) {
                sawEnergyDrinks = true;
            }
            if (talk.getDistanceReduction() == 0) {
                sawNoEnergyDrinks = true;
            }
        }

        assertTrue(sawEnergyDrinks);
        assertTrue(sawNoEnergyDrinks);
    }
}

import java.util.List;
import student.TestCase;

/**
 * Test class for Freshman class
 * 
 * @author Aleysa sweeney
 * @version 2026.09.24
 */

public class FreshmanTest extends TestCase {

    /**
     * tests that freshman encounter is initalized correctly
     */
    public void testInitialization() {
        Freshman f = new Freshman();

        List<Choice> choices = f.getChoices();

        assertNotNull(choices);
        assertEquals(2, choices.size());

        Choice talk = choices.get(0);
        assertTrue(talk.getMenuText().contains("Freshman"));
        assertEquals(-5, talk.getTimeCost());
        assertEquals(0, talk.getDistanceReduction());

        Choice directions = choices.get(1);
        assertEquals("Give directions", directions.getMenuText());
        assertEquals(-10, directions.getTimeCost());
        assertEquals(0, directions.getDistanceReduction());
    }


    /**
     * tests the directions choice values
     */
    public void testDirectionsChoice() {
        Freshman f = new Freshman();

        Choice directions = f.getChoices().get(1);

        assertEquals("Give directions", directions.getMenuText());
        assertEquals("You helped the freshman find their class", directions
            .getResultText());
        assertEquals(-10, directions.getTimeCost());
        assertEquals(0, directions.getDistanceReduction());
    }
}

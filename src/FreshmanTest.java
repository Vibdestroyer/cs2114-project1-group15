import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for Freshman
 *
 * @author Sarah Gage
 * @version 2026.09.24
 */
public class FreshmanTest {
    // ----------------------------------------------------------
    /**
     * test getChoices
     */
    @Test
    public void testGetChoices() {
        Freshman f = new Freshman();
        assertEquals(f.getChoices().get(0).getTimeCost(), 5);
        assertEquals(f.getChoices().get(0).getDistanceReduction(), 0);
        assertEquals(f.getChoices().get(1),
                new Choice("Give directions", "You helped the freshman find their class", 10, 0));
    }
}

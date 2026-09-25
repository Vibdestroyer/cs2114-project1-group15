import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for Friend
 *
 * @author Sarah Gage
 * @version 2026.09.24
 */
public class FriendTest {
    // ----------------------------------------------------------
    /**
     * test getChoices
     */
    @Test
    public void testGetChoices() {
        Friend f = new Friend();
        assertEquals(f.getChoices().get(0).getTimeCost(), 5);
        assertEquals(f.getChoices().get(0).getDistanceReduction(), 0);
        if (f.getChoices().size() > 2) {
            assertEquals(f.getChoices().get(1).getTimeCost(), 5);
            assertEquals(f.getChoices().get(1).getDistanceReduction(), 5);
            assertEquals(f.getChoices().get(2).getTimeCost(), 5);
            assertEquals(f.getChoices().get(2).getDistanceReduction(), 10);
        } else if (f.getChoices().size() > 1) {
            assertEquals(f.getChoices().get(1).getTimeCost(), 5);
            assertTrue(f.getChoices().get(1).getDistanceReduction() == 5 || f
                    .getChoices().get(1).getDistanceReduction() == 10);
        }
    }
}

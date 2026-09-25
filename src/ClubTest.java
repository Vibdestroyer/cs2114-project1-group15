import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for Club
 *
 * @author Sarah Gage
 * @version 2026.09.24
 */
public class ClubTest {
    // ----------------------------------------------------------
    /**
     * test getChoices
     */
    @Test
    public void testGetChoices() {
        Club c = new Club();
        assertEquals(c.getChoices().get(0).getMenuText(), "Talk to club members");
    }
}

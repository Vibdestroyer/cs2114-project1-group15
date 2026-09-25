import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for Person
 *
 * @author Sarah Gage
 * @version 2026.09.24
 */
public class PersonTest {
    // ----------------------------------------------------------
    /**
     * test getChoices
     */
    @Test
    public void testGetChoices() {
        Person p = new Person();
        assertEquals(p.getChoices().get(0).getTimeCost(), 5);
        assertEquals(p.getChoices().get(0).getDistanceReduction(), 0);
    }
}

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Bus
 *
 * @author Sarah Gage
 * @version 2026.09.24
 */
public class BusTest {
    // ----------------------------------------------------------
    /**
     * test getChoices
     */
    @Test
    public void testGetChoices() {
        Bus b = new Bus();
        List<Choice> c1 = new ArrayList<>();
        c1.add(new Choice("Wait for another bus",
            "The bus is full. You wait 2 minutes.", 2, 0));
        assertTrue(b.getChoices().equals(c1) || b.getChoices().get(0)
            .getDistanceReduction() == 7);
    }
}

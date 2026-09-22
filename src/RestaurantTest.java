import student.TestCase;
import java.util.List;


public class RestaurantTest extends TestCase {

    /**
     * Tests basic setup and values.
     */
    public void testInitialization() {
        Restaurant r = new Restaurant();

        assertNotNull(r.getScenario());
        assertFalse(r.getScenario().isEmpty());

        List<Choice> choices = r.getChoices();
        assertNotNull(choices);
        assertEquals(1, choices.size());

        Choice choice = choices.get(0);
        assertEquals("Get food from restaurant", choice.getMenuText());
        assertNotNull(choice.getResultText());
        assertEquals(3, choice.getDistanceReduction());
    }

    /**
     * Tests time cost calculation.
     */
    public void testDynamicTimeCostCalculation() {
        for (int i = 0; i < 50; i++) {
            Restaurant r = new Restaurant();
            Choice choice = r.getChoices().get(0);

            int expectedTime = 10;
            if (r.getTakesOnlineOrders()) {
                expectedTime -= 4;
            }
            if (r.isGrabAndGo()) {
                expectedTime -= 4;
            }

            assertEquals(expectedTime, choice.getTimeCost());
        }
    }

    /**
     * Tests all combinations of boolean flags.
     */
    public void testAllBranchCombinationsCovered() {
        boolean seenBothFalse = false;
        boolean seenBothTrue = false;
        boolean seenOnlineOnly = false;
        boolean seenGrabOnly = false;

        for (int i = 0; i < 150; i++) {
            Restaurant r = new Restaurant();
            boolean online = r.getTakesOnlineOrders();
            boolean grab = r.isGrabAndGo();

            if (!online && !grab) {
                seenBothFalse = true;
                assertEquals(10, r.getChoices().get(0).getTimeCost());
            } 
            else if (online && grab) {
                seenBothTrue = true;
                assertEquals(2, r.getChoices().get(0).getTimeCost());
            } 
            else if (online && !grab) {
                seenOnlineOnly = true;
                assertEquals(6, r.getChoices().get(0).getTimeCost());
            } 
            else {
                seenGrabOnly = true;
                assertEquals(6, r.getChoices().get(0).getTimeCost());
            }
        }

        assertTrue(seenBothFalse);
        assertTrue(seenBothTrue);
        assertTrue(seenOnlineOnly);
        assertTrue(seenGrabOnly);
    }
}

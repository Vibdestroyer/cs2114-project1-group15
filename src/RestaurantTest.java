import student.TestCase;

// Tests the Restaurant class.
public class RestaurantTest extends TestCase {

    private Restaurant restaurant;

    // Set up. 
    public void setUp() {
        restaurant = new Restaurant();
    }

    // Tests the distance and choice description. 
    public void testEncounterChoiceCreation() {
        assertNotNull(restaurant.getChoices());
        assertEquals(1, restaurant.getChoices().size());

        Choice choice = restaurant.getChoices().get(0);
        assertEquals("Get food from restaurant", choice.getDescription());
        assertEquals(-3, choice.getDistanceChange());
    }

    // Test the time change values.
    public void testValidTimeChangeRange() {
        for (int i = 0; i < 50; i++) {
            Restaurant r = new Restaurant();
            int time = r.getChoices().get(0).getTimeChange();
            assertTrue(time == -10 || time == -6 || time == -2);
        }
    }
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for Choice
 *
 * @author Sarah Gage 
 * @version 2026.09.18
 */
public class ChoiceTest {
    // ----------------------------------------------------------
    /**
     * test getMenuText()
     */
    @Test
    public void testGetMenuText() {
        Choice choice = new Choice("menu text test", "result text test", 20, 20);
        assertEquals(choice.getMenuText(), "menu text test");
    } 
    
    // ----------------------------------------------------------
    /**
     * test getResultText()
     */
    @Test
    public void testGetResultText() {
        Choice choice = new Choice("menu text test", "result text test", 20, 20);
        assertEquals(choice.getResultText(), "result text test");
    }  

    // ----------------------------------------------------------
    /**
     * test getTimeCost()
     */
    @Test
    public void testGetTimeCost() {
        Choice choice = new Choice("menu text test", "result text test", 20, 20);
        assertEquals(choice.getTimeCost(), 20);
    }  

    // ----------------------------------------------------------
    /**
     * test getDistanceReduction()
     */
    @Test
    public void testGetDistanceReduction() {
        Choice choice = new Choice("menu text test", "result text test", 20, 25);
        assertEquals(choice.getDistanceReduction(), 25);
    }  

    // ----------------------------------------------------------
    /**
     * test equals()
     */
    @Test
    public void testEquals() {
        Choice choice = new Choice("menu text test", "result text test", 20, 25);
        assertTrue(choice.equals(choice));
        assertFalse(choice.equals(null));
        assertFalse(choice.equals("choice2"));
        assertTrue(choice.equals(new Choice("menu text test", "result text test", 20, 25)));
        assertFalse(choice.equals( new Choice("not menu text test", "result text test", 20, 25)));
        assertFalse(choice.equals( new Choice("menu text test", "not result text test", 20, 25)));
        assertFalse(choice.equals( new Choice("menu text test", "result text test", 25, 25)));
        assertFalse(choice.equals( new Choice("menu text test", "result text test", 20, 20)));

    }
}

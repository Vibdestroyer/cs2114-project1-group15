import static org.junit.Assert.assertEquals;
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
}

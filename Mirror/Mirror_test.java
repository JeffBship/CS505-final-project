

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Mirror_test.
 *
 * @author  Emily Park
 * @version 1.0
 */
public class Mirror_test
{
    /**
     * Default constructor for test class Mirror_test
     */
    public Mirror_test()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
       Mirror mirror;
       Widget widgetOne = new Widget();
       Widget widgetTwo = new Widget();
       Widget widgetThree = new Widget();
       Widget widgetFour = new Widget();
       Widget widgetFive = new Widget();
       Widget widgetNull = null;
    }
    @Test
    public void testGetInstance(){
        assertEquals(mirror.GetInstance());
    }
    @Test
    public void testNullAdd(){
        mirror.AddWidget(widgetNull);
        assertEquals(widgetNull,mirror.getWidget(0));
    }
    @Test
    public void testOneAdd(){
        mirror.AddWidget(widgetOne);
        assertEquals(widgetOne,mirror.getWidget(0));
    }
    @Test
    public void testTwoAdd(){
        mirror.AddWidget(widgetTwo);
        assertEquals(widgetTwo, mirror.getWidget(1));
    }
     @Test
    public void testThreeAdd(){
        mirror.AddWidget(widgetThree);
        assertEquals(widgetThree, mirror.getWidget(2));
    }
     @Test
    public void testFourAdd(){
        mirror.AddWidget(widgetFour);
        assertEquals(widgetTFour, mirror.getWidget(3));
    }
     @Test
    public void testFiveAdd(){
        assertEquals(mirror.AddWidget(widgetFive), IndexOutOfBoundsException);
    }
    @Test
    public void knobZero(){
        assertequals(mirror.SetActive(0),widgetOne);
    }
    @Test
    public void knobNinety(){
        assertequals(mirror.SetActive(90),widgetTwo);
    }
    @Test
    public void knobOneEighty(){
        assertequals(mirror.SetActive(180),widgetThree);
    }
    @Test
    public void knobTwoSeventy(){
        assertequals(mirror.SetActive(270),widgetFour);
    }
    @Test
    public void knobFiveTwenty(){
        assertequals(mirror.SetActive(520),widgetTwo);
    }
    @Test
    public void testFiveRemove(){
        assertequals(mirror.RemoveWidget(widgetFive), false);
    }
    @Test
    public void testFourRemove(){
        assertequals(mirror.RemoveWidget(widgetFour), true);
    }
    @Test
    public void testThreeRemove(){
        assertequals(mirror.RemoveWidget(widgetThree), true);
    }
    @Test
    public void testTwoRemove(){
        assertequals(mirror.RemoveWidget(widgetTwo), true);
    }
    @Test
    public void testOneRemove(){
        assertequals(mirror.RemoveWidget(widgetOne), true);
    }
    @Test
    public void testNullRemove(){
        assertequals(mirror.RemoveWidget(widgetNull), false);
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}

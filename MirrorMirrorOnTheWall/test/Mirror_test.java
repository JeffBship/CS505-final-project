

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
    public void resetSingleton()
    {
       Mirror.ResetSingleton();
    }
    
    @Test
    public void testGetInstance(){
        System.out.println("GetInstance");
        Mirror result = Mirror.GetInstance();
        
        assertEquals(result.getClass().getName(),"Mirror");
    }
    @Test
    public void testNullAdd(){
        Mirror instance = Mirror.GetInstance();
        Widget w = null;
        instance.AddWidget(null);
        
        assertEquals(w,instance.GetWidget(0));
    }
    @Test
    public void testOneAdd(){
        Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
        mirror.AddWidget(widgetOne);
        assertEquals(widgetOne,instance.GetWidget(0));
    }
    @Test
    public void testTwoAdd(){
        Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        assertEquals(widgetTwo, instance.getWidget(1));
    }
     @Test
    public void testThreeAdd(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        assertEquals(widgetThree, instance.getWidget(2));
    }
     @Test
    public void testFourAdd(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertEquals(widgetFour, instance.getWidget(3));
    }
     @Test
    public void testFiveAdd(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	Widget widgetFive = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertEquals(instance.AddWidget(widgetFive), IndexOutOfBoundsException);
    }
    @Test
    public void knobZero(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.SetActive(0),widgetOne);
    }
    @Test
    public void knobNinety(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.SetActive(90),widgetTwo);
    }
    @Test
    public void knobOneEighty(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.SetActive(180),widgetThree);
    }
    @Test
    public void knobTwoSeventy(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.SetActive(270),widgetFour);
    }
    @Test
    public void knobFiveTwenty(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.SetActive(520),widgetTwo);
    }
    @Test
    public void testFiveRemove(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.RemoveWidget(widgetFive), false);
    }
    @Test
    public void testFourRemove(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.RemoveWidget(widgetFour), true);
    }
    @Test
    public void testThreeRemove(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.RemoveWidget(widgetThree), true);
    }
    @Test
    public void testTwoRemove(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.RemoveWidget(widgetTwo), true);
    }
    @Test
    public void testOneRemove(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.RemoveWidget(widgetOne), true);
    }
    @Test
    public void testNullRemove(){
	Mirror instance = Mirror.GetInstance();
	Widget widgetOne = new Widget();
	Widget widgetTwo = new Widget();
	Widget widgetThree = new Widget();
	Widget widgetFour = new Widget();
	Widget widgetNull = null;
	instance.AddWidget(widgetOne);
        instance.AddWidget(widgetTwo);
        instance.AddWidget(widgetThree);
        instance.AddWidget(widgetFour);
        assertequals(instance.RemoveWidget(widgetNull), false);
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

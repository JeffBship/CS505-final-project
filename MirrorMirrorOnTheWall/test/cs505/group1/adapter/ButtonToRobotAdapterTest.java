package cs505.group1.adapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeff Blankenship
 */
public class ButtonToRobotAdapterTest {
  
  public ButtonToRobotAdapterTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of singlePress method, of class ButtonToRobotAdapter.
   */
  @Test
  public void testSinglePress() {
    System.out.println("singlePress");
    ButtonToRobotAdapter instance = null;
  }

  /**
   * Test of doublePress method, of class ButtonToRobotAdapter.
   */
  @Test
  public void testDoublePress() {
    System.out.println("doublePress");
    ButtonToRobotAdapter instance = null;
  }

  /**
   * Test of longPress method, of class ButtonToRobotAdapter.
   */
  @Test
  public void testLongPress() {
    System.out.println("longPress");
    ButtonToRobotAdapter instance = null;
  }

  public class ButtonToRobotAdapterImpl extends ButtonToRobotAdapter {

    public ButtonToRobotAdapterImpl() {
      super(null);
    }

    public void singlePress() {
    }

    public void doublePress() {
    }

    public void longPress() {
    }
  }
  
}

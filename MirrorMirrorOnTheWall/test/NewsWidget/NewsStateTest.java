package NewsWidget;

import cs505.group1.state.ButtonState;
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
public class NewsStateTest {
  
  public NewsStateTest() {
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
   * Test of singlePress method, of class NewsState.
   */
  @Test
  public void testSinglePress() {
    System.out.println("singlePress");
    NewsState instance = new NewsState();
    ButtonState result = instance.singlePress();
    assertNotNull(result);
  }

  /**
   * Test of doublePress method, of class NewsState.
   */
  @Test
  public void testDoublePress() {
    System.out.println("doublePress");
    NewsState instance = new NewsState();
    ButtonState result = instance.doublePress();
    assertNotNull(result);
  }

  /**
   * Test of longPress method, of class NewsState.
   */
  @Test
  public void testLongPress() {
    System.out.println("longPress");
    NewsState instance = new NewsState();
    ButtonState result = instance.longPress();
    assertNotNull(result);
  }
  
}

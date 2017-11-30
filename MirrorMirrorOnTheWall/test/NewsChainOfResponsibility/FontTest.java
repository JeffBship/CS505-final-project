package NewsChainOfResponsibility;

import cs505.group1.font.Font;
import javax.swing.text.SimpleAttributeSet;
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
public class FontTest {
  
  public FontTest() {
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
   * Test of bigCNN method, of class Font.
   */
  @Test
  public void testBigCNN() {
    System.out.println("bigCNN");
    SimpleAttributeSet result = Font.bigCnn();
    assertNotNull(result);
  }

  /**
   * Test of smallCNN method, of class Font.
   */
  @Test
  public void testSmallCNN() {
    System.out.println("smallCNN");
    SimpleAttributeSet result = Font.smallCnn();
    assertNotNull(result);
  }

  /**
   * Test of bigFOX method, of class Font.
   */
  @Test
  public void testBigFOX() {
    System.out.println("bigFOX");
    SimpleAttributeSet result = Font.bigFox();
    assertNotNull(result);
  }

  /**
   * Test of smallFOX method, of class Font.
   */
  @Test
  public void testSmallFOX() {
    System.out.println("smallFOX");
    SimpleAttributeSet result = Font.smallFox();
    assertNotNull(result);
  }

  /**
   * Test of bigFAIL method, of class Font.
   */
  @Test
  public void testBigFAIL() {
    System.out.println("bigFAIL");
    SimpleAttributeSet result = Font.bigFail();
    assertNotNull(result);
  }

  /**
   * Test of smallFAIL method, of class Font.
   */
  @Test
  public void testSmallFAIL() {
    System.out.println("smallFAIL");
    SimpleAttributeSet result = Font.smallFail();
    assertNotNull(result);
  }
  
}

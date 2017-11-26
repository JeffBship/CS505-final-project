package NewsChainOfResponsibility;

import NewsWidget.Story;
import java.util.ArrayList;
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
public class FoxRSSTest {
  
  public FoxRSSTest() {
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
   * Test of makeStoryList method, of class FoxRSS.
   */
  @Test
  public void testMakeStoryList() {
    System.out.println("makeStoryList");
    FoxRSS instance = new FoxRSS();
    ArrayList<Story> result = instance.makeStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getStoryList method, of class FoxRSS.
   */
  @Test
  public void testGetStoryList() {
    System.out.println("getStoryList");
    FoxRSS instance = new FoxRSS();
    ArrayList<Story> result = instance.getStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getBigFont method, of class FoxRSS.
   */
  @Test
  public void testGetBigFont() {
    System.out.println("getBigFont");
    FoxRSS instance = new FoxRSS();
    SimpleAttributeSet result = instance.getBigFont();
    assertNotNull(result);
  }

  /**
   * Test of getSmallFont method, of class FoxRSS.
   */
  @Test
  public void testGetSmallFont() {
    System.out.println("getSmallFont");
    FoxRSS instance = new FoxRSS();
    SimpleAttributeSet result = instance.getSmallFont();
    assertNotNull(result);
  }

  /**
   * Test of setSuccessor method, of class FoxRSS.
   */
  @Test
  public void testSetSuccessor() {
    System.out.println("setSuccessor");
    RSShandler rss = null;
    FoxRSS instance = new FoxRSS();
    instance.setSuccessor(rss);
  }
  
}

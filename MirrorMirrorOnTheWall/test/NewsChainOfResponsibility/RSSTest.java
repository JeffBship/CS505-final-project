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
public class RSSTest {
  
  public RSSTest() {
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
   * Test of makeStoryList method, of class RSS.
   */
  @Test
  public void testMakeStoryList() {
    System.out.println("makeStoryList");
    RSS instance = new RSS();
    ArrayList<Story> result = instance.makeStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getStoryList method, of class RSS.
   */
  @Test
  public void testGetStoryList() {
    System.out.println("getStoryList");
    RSS instance = new RSS();
    ArrayList<Story> result = instance.getStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getBigFont method, of class RSS.
   */
  @Test
  public void testGetBigFont() {
    System.out.println("getBigFont");
    RSS instance = new RSS();
    SimpleAttributeSet result = instance.getBigFont();
    assertNotNull(result);
  }

  /**
   * Test of getSmallFont method, of class RSS.
   */
  @Test
  public void testGetSmallFont() {
    System.out.println("getSmallFont");
    RSS instance = new RSS();
    SimpleAttributeSet result = instance.getSmallFont();
    assertNotNull(result);
  }

  /**
   * Test of setSuccessor method, of class RSS.
   */
  @Test
  public void testSetSuccessor_RSS() {
    System.out.println("setSuccessor");
    RSS rss = null;
    RSS instance = new RSS();
    instance.setSuccessor(rss);
  }

  /**
   * Test of setSuccessor method, of class RSS.
   */
  @Test
  public void testSetSuccessor_RSShandler() {
    System.out.println("setSuccessor");
    RSShandler rss = null;
    RSS instance = new RSS();
    instance.setSuccessor(rss);
  }
  
}

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
public class failRSSTest {
  
  public failRSSTest() {
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
   * Test of makeStoryList method, of class failRSS.
   */
  @Test
  public void testMakeStoryList() {
    System.out.println("makeStoryList");
    failRSS instance = new failRSS();
    ArrayList<Story> result = instance.makeStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getStoryList method, of class failRSS.
   */
  @Test
  public void testGetStoryList() {
    System.out.println("getStoryList");
    failRSS instance = new failRSS();
    ArrayList<Story> result = instance.getStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getBigFont method, of class failRSS.
   */
  @Test
  public void testGetBigFont() {
    System.out.println("getBigFont");
    failRSS instance = new failRSS();
    SimpleAttributeSet result = instance.getBigFont();
    assertNotNull(result);
  }

  /**
   * Test of getSmallFont method, of class failRSS.
   */
  @Test
  public void testGetSmallFont() {
    System.out.println("getSmallFont");
    failRSS instance = new failRSS();
    SimpleAttributeSet result = instance.getSmallFont();
    assertNotNull(result);
  }

  /**
   * Test of setSuccessor method, of class failRSS.
   */
  @Test
  public void testSetSuccessor() {
    System.out.println("setSuccessor");
    RSShandler rss = null;
    failRSS instance = new failRSS();
    instance.setSuccessor(rss);
  }
  
}

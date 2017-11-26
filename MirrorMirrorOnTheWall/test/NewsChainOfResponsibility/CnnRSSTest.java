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
public class CnnRSSTest {
  
  public CnnRSSTest() {
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
   * Test of makeStoryList method, of class CnnRSS.
   */
  @Test
  public void testMakeStoryList() {
    System.out.println("makeStoryList");
    CnnRSS instance = new CnnRSS();
    ArrayList<Story> result = instance.makeStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getStoryList method, of class CnnRSS.
   */
  @Test
  public void testGetStoryList() {
    System.out.println("getStoryList");
    CnnRSS instance = new CnnRSS();
    ArrayList<Story> result = instance.getStoryList();
    assertNotNull(result);
  }

  /**
   * Test of getBigFont method, of class CnnRSS.
   */
  @Test
  public void testGetBigFont() {
    System.out.println("getBigFont");
    CnnRSS instance = new CnnRSS();
    SimpleAttributeSet result = instance.getBigFont();
    assertNotNull(result);
  }

  /**
   * Test of getSmallFont method, of class CnnRSS.
   */
  @Test
  public void testGetSmallFont() {
    System.out.println("getSmallFont");
    CnnRSS instance = new CnnRSS();
    SimpleAttributeSet result = instance.getSmallFont();
    assertNotNull(result);
  }

  /**
   * Test of setSuccessor method, of class CnnRSS.
   */
  @Test
  public void testSetSuccessor() {
    System.out.println("setSuccessor");
    RSShandler rss = null;
    CnnRSS instance = new CnnRSS();
    instance.setSuccessor(rss);
  }
  
}

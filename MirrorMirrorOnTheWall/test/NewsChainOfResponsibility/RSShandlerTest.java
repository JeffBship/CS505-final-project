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
public class RSShandlerTest {
  
  public RSShandlerTest() {
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
   * Test of makeStoryList method, of class RSShandler.
   */
  @Test
  public void testMakeStoryList() {
    System.out.println("makeStoryList");
    RSShandler instance = new RSShandlerImpl();
    ArrayList<Story> result = instance.makeStoryList();
    assertNull(result);
  }

  /**
   * Test of getStoryList method, of class RSShandler.
   */
  @Test
  public void testGetStoryList() {
    System.out.println("getStoryList");
    RSShandler instance = new RSShandlerImpl();
    ArrayList<Story> result = instance.getStoryList();
    assertNull(result);
  }

  /**
   * Test of getBigFont method, of class RSShandler.
   */
  @Test
  public void testGetBigFont() {
    System.out.println("getBigFont");
    RSShandler instance = new RSShandlerImpl();
    SimpleAttributeSet result = instance.getBigFont();
    assertNull(result);
  }

  /**
   * Test of getSmallFont method, of class RSShandler.
   */
  @Test
  public void testGetSmallFont() {
    System.out.println("getSmallFont");
    RSShandler instance = new RSShandlerImpl();
    SimpleAttributeSet result = instance.getSmallFont();
    assertNull(result);
  }

  /**
   * Test of setSuccessor method, of class RSShandler.
   */
  @Test
  public void testSetSuccessor() {
    System.out.println("setSuccessor");
    RSShandler rss = null;
    RSShandler instance = new RSShandlerImpl();
    instance.setSuccessor(rss);
  }

  public class RSShandlerImpl extends RSShandler {

    public ArrayList<Story> makeStoryList() {
      return null;
    }

    public ArrayList<Story> getStoryList() {
      return null;
    }

    public SimpleAttributeSet getBigFont() {
      return null;
    }

    public SimpleAttributeSet getSmallFont() {
      return null;
    }

    public void setSuccessor(RSShandler rss) {
    }
  }
  
}

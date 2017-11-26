package NewsChainOfResponsibility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Jeff Blankenship
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({NewsChainOfResponsibility.CnnRSSTest.class, NewsChainOfResponsibility.failRSSTest.class, NewsChainOfResponsibility.RSSTest.class, NewsChainOfResponsibility.FontTest.class, NewsChainOfResponsibility.RSShandlerTest.class, NewsChainOfResponsibility.FoxRSSTest.class})
public class NewsChainOfResponsibilitySuite {

  @BeforeClass
  public static void setUpClass() throws Exception {
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  
}

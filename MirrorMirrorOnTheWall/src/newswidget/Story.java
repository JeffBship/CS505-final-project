
package newswidget;

/**
 *Story class provides an object to store titles and descriptions of news stories.
 * @author Jeff Blankenship
 */
public class Story {
  String title;
  String description;
  
  /**
   * Constructor
   * @param title 
   */
  public Story(String title){
    this.title = title;
    this.description = "";
  }
  
  /**
   * Sets the title of the Story object to the passed string
   * @param title string
   */
  public void setTitle(String title){
    this.title = title;
  }
  
  /**
   * Obtains the title of the Story object.
   * @return String title
   */
  public String getTitle(){
    return title;
  }
  
  /**
   * 
   * @param description 
   */
  public void setDescription(String description){
    this.description = description;
  }
  
  /**
   * 
   * @return 
   */
  String getDescription(){
    return description;
  }
  
  
  /**
   * 
   * @return 
   */
  @Override
  public String toString(){
    String result = title;
    if (!description.equals("")){
      result += "\n  " + description;
    }
    return result;
  }
  
}

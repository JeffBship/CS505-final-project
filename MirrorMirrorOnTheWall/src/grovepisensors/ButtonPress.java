package grovepisensors;

/**
 * Enumeration for the different types of button presses
 * @author James Luczynski
 */
enum ButtonPress {
    SINGLE("Single"), 
    DOUBLE("Double"), 
    LONG("Long");
    
    private final String pressType;
    
    private ButtonPress(String pressType){
        this.pressType = pressType;
    }
    
    /**
     * @Override in class Enum
     * @return String description of the button press type
     */
    public String toString(){
        return pressType;
    }
}

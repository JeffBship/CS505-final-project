package MirrorMirrorOnTheWall;

/**
* Enumerated Type for dial
*/
public enum Quadrant{
	ONE("one"), TWO("two"), THREE("three"), FOUR("four");
        
	private final String name;
	private Quadrant(String name){
		this.name = name;
	}
        
        @Override
        public String toString()
        {
            return this.name;
        }
}
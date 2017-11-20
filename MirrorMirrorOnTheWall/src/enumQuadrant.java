/**
* Enumerated Type for dial
*/
public enum Quadrant{
	ONE("one");
	TWO("two");
	THREE("three");
	FOUR("four");
	private final Strng name;
	private Quadrant(String name){
		this.name = name;
	}
}
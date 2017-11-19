/**
* Enumerated Type for dial
*/
public enum Quadrant{
	ONE(1);
	TWO(2);
	THREE(3);
	FOUR(4);
	private final int name;
	private Quadrant(int name){
		this.name = name;
	}
}
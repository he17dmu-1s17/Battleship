package battleship.logic;

public enum ShipClass {
	
	Carrier(5), 
	Battleship(4), 
	Cruiser(3),
	Submarine(3),
	Destroyer(2);
	
	private int size;
	
	private ShipClass(int size) {
		this.size=size;
	}

	public int getSize() {
		return size;
	}
}

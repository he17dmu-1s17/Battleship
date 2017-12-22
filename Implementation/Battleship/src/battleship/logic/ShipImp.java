package battleship.logic;

public class ShipImp implements Ship {

 private int damage;
 private boolean placed;
 private ShipClass shipClass;
 
 	public ShipImp(ShipClass shipClass) {
 		this.shipClass = shipClass;
 		placed = false;
 		damage = 0;
 	}


	@Override
	public int getSize() {
		int size=shipClass.getSize();
		return size;
	}

	@Override
	public boolean isSunk() {
		if(damage == getSize())
		return true;
		else return false;
	}

	@Override
	public boolean isPlaced() {
		
		return placed;
	}

	@Override
	public void receiveDamage() {
		damage++;
	}

}

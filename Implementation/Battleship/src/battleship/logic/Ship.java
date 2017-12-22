package battleship.logic;

public interface Ship {
	
	public int getSize();
	
	public boolean isSunk();
	
	public boolean isPlaced();
	
	public void receiveDamage();

	public void donePlacing();

}

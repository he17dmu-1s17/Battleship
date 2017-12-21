package battleship.logic;

public interface Player {
	
	public Square shoot(int column, int row);
	
	public void getShotAt(int column, int row);
	
	public Grid getTargetGrid();
	
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal);

	public Grid getFleetGrid();

	public boolean allShipsSunk();
	
}

package battleship.logic;

import java.util.List;

public interface Player {
	
	public Square shoot(int column, int row);
	
	public void getShotAt(int column, int row);
	
	public Grid getTargetGrid();
	
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal);

	public Grid getFleetGrid();

	public boolean allShipsSunk();//vi mangle den i DCD Diagram og jeg hat tilfæget den Shahnaz
	public List[] getShips(); //vi mangle den i DCD Diagram og jeg hat tilfæget den Shahnaz
	
}

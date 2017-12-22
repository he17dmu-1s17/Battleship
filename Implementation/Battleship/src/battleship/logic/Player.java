package battleship.logic;

import java.util.HashMap;
import java.util.List;

public interface Player {
	
	public Square shoot(int column, int row) throws AlreadyShotException;
	
	public Grid getTargetGrid();
	
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) throws AlreadyPlacedException, OutOfBoundsException, SquareOccupiedException;

	public Grid getFleetGrid();

	public boolean allShipsSunk();//vi mangle den i DCD Diagram og jeg hat tilfæget den Shahnaz
	public HashMap getShips(); //vi mangle den i DCD Diagram og jeg hat tilfæget den Shahnaz
	
}

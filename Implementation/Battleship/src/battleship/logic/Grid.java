package battleship.logic;

public interface Grid {
	
	public void placeShip(Ship ship, int column, int row, boolean isHorizontal) throws AlreadyPlacedException, OutOfBoundsException, SquareOccupiedException;
	
	public Square shoot(int column, int row);

}

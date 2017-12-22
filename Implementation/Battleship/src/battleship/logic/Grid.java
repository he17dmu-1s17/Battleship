package battleship.logic;

public interface Grid {
	
	public void placeShip(Ship ship, int column, int row, boolean isHorizontal) throws AlreadyPlacedException, OutOfBoundsException, SquareOccupiedException;
	
	public Square shoot(int column, int row) throws AlreadyShotException;

	public boolean isOccupied(int i, int j);

	public SquareStatus getSquareStatus(int column, int row);

}

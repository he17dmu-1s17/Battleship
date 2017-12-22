package battleship.logic;

public interface Square {
	
	public boolean isOccupied();
	
	/**
	 * @param ship
	 * @param column probably isn't needed
	 * @param row probably isn't needed
	 * @throws SquareOccupiedException 
	 */
	public void placeShip(Ship ship, int column, int row) throws SquareOccupiedException;
	
	public void receiveShot() throws AlreadyShotException;

	public SquareStatus getStatus();

}

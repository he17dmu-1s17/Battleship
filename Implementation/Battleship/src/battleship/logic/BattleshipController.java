package battleship.logic;

public interface BattleshipController {
	
	/**
	 * @return true if the game is ready to start
	 */
	public boolean isReadyToStart();
	
	public Grid getTargetGrid(boolean isPlayer1);
	
	public void startGame();
	
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) throws AlreadyPlacedException;
	
	public boolean isGameOver();
	
	public void endTurn();
	
	public Square takeShot(int column, int row);
	
	public void initializeGame();
	
	public Player getWinner();
	public Grid getFleetGrid();

}

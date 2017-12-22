package battleship.logic;

import javafx.collections.ObservableList;

public interface BattleshipController {
	
	/**
	 * @return true if the game is ready to start
	 */
	public boolean isReadyToStart();
	
	public Grid getTargetGrid(boolean isPlayer1);
	
	public void startGame();
	
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) throws AlreadyPlacedException, OutOfBoundsException, SquareOccupiedException;
	
	public boolean isGameOver();
	
	public void endTurn();
	
	public Square takeShot(int column, int row) throws AlreadyShotException;
	
	public Player getWinner();
	
	public Grid getFleetGrid();

	public Object getCurrentPlayerName();

	public String getPlayer1Name();

	public String getPlayer2Name();

	public ObservableList<ShipClass> getShipList();

	public void setupDone();

}

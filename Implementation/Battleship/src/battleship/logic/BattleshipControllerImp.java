package battleship.logic;

public class BattleshipControllerImp implements  BattleshipController{
private Player player1;
private Player player2;
private Player curentPlayer;
private boolean isReadyToStart;
private boolean gameOver;
	@Override
	public boolean isReadyToStart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Grid getTargetGrid(boolean isPlayer1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isGameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Square takeShot(int column, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getWinner() {
		// TODO Auto-generated method stub
		return null;
	}

}

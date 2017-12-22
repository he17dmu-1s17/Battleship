package battleship.logic;
public class BattleshipControllerImp implements BattleshipController {
	private Player player1;
	private Player player2;
	private Player curentPlayer;
	private boolean isReadyToStart;
	private boolean gameOver;
	private boolean gameStarted;// jeg har tilføjet den vi mangler den i complate DCD

	public BattleshipControllerImp(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	@Override
	public boolean isReadyToStart() {

		return false;
	}

	@Override
	public Grid getTargetGrid(boolean isPlayer1) {
		Grid tragetGrid;
		if (isPlayer1) {
			tragetGrid = player1.getTargetGrid();
		} else {
			tragetGrid = player1.getTargetGrid();
		}

		return tragetGrid;
	}

	@Override
	public void startGame() {
		while (isReadyToStart()) {
			gameStarted = true;
		}

	}

	@Override
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) {
		curentPlayer.placeShip(shipClass, column, row, isHorizontal);
	}

	@Override
	public boolean isGameOver() {
		return gameOver;
	}

	@Override
	public void endTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public Square takeShot(int column, int row) {
		Square squre;
		squre = curentPlayer.shoot(column, row);
		endTurn();
		return squre;
	}

	@Override
	public void initializeGame() {
		Player player1 = new PlayerImp();
		Player player2 = new PlayerImp();
		BattleshipControllerImp battleshipController = new BattleshipControllerImp(player1, player2);
	}

	@Override
	public Player getWinner() {
		return endGame();
	}

	private Player endGame() {
		// vi skal laver allShipsSunk metud i Player
		Player winner;
		gameOver = true;
		if (player1.allShipsSunk()) {
			winner = player2;
		} else {
			winner = player1;
		}
		return winner;
	}

	@Override
	public Grid getFleetGrid() {// vi har glemt den i interface
		while (!isGameOver())
			return null;
		return curentPlayer.getFleetGrid();

	}

}

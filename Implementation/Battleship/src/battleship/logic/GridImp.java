package battleship.logic;

public class GridImp implements Grid {

	private static int row = 10;
	private static int column = 10;
	private int size;

	Square[][] squares = new Square[column][row];

	@Override
	public void placeShip(Ship ship, int column, int row, boolean isHorizontal) throws AlreadyPlacedException, OutOfBoundsException, SquareOccupiedException {
		size = ship.getSize();
		if (isHorizontal) {
			if (ship.isPlaced() == true) {
				throw new AlreadyPlacedException();
			} else {
				if (ship.getSize() + column >= 10) {
					throw new OutOfBoundsException();
				} else {
					for (;size > 0; column++) {
						if (squares[column][row].isOccupied()) {
							throw new SquareOccupiedException();
						} else {
							squares[column][row].placeShip(ship);
							size--;
						}

					}
				}
			}
		} else {
			if (ship.isPlaced() == true)   {
				throw new AlreadyPlacedException();
			} else {
				if (ship.getSize() + row >= 10) {
					throw new OutOfBoundsException();
				} else {
					for (;size > 0; row++) {
						if (squares[column][row].isOccupied()) {
							throw new SquareOccupiedException();
						} else {
							squares[column][row].placeShip(ship);
							size--;
						}

					}
				}
			}
		}
	}

	@Override
	public Square shoot(int column, int row) throws AlreadyShotException {
		squares[column][row].receiveShot();
		return squares[column][row];
	}
	
	public Square getSquare(int column, int row) {
		return squares[column][row];
	}
	public boolean isOccupied(int column, int row){
		return squares[column][row].isOccupied();
	
	}
	public SquareStatus getSquareStatus(int column, int row) {
		return squares[column][row].getStatus();
	}

}

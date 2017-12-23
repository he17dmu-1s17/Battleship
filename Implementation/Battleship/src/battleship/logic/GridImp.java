package battleship.logic;

public class GridImp implements Grid {

	private static int row = 10;
	private static int column = 10;
	private int size;

	Square[][] squares = new Square[column][row];
	
	public GridImp() {
		for (int col = 0; col<column; col++)
			for (int ro = 0; ro<row; ro++)
				squares[col][ro] = new SquareImp();
	}

	@Override
	public void placeShip(Ship ship, int column, int row, boolean isHorizontal) throws AlreadyPlacedException, OutOfBoundsException, SquareOccupiedException {
		size = ship.getSize();
		if (isHorizontal) {
			if (ship.isPlaced() == true) {
				throw new AlreadyPlacedException();
			} else {
				if (ship.getSize() + column > 10) {
					throw new OutOfBoundsException();
				} else {
					boolean unOccupied = false;
					int col = column;
					for (int siz = size; siz > 0; col++, siz--) {
						if (squares[col][row].isOccupied()) {
							throw new SquareOccupiedException();
						} else if (siz == 1) {
							unOccupied = true;
						}
					}
					for (int siz = size; siz > 0; column++, siz--) {
						 if (unOccupied == true) {
								squares[column][row].placeShip(ship);
							}
					}
					ship.donePlacing();
				}
			}
		} else {
			if (ship.isPlaced() == true)   {
				throw new AlreadyPlacedException();
			} else {
				if (ship.getSize() + row >= 10) {
					throw new OutOfBoundsException();
				} else {
					boolean unOccupied = false;
					int ro = row;
					for (int siz = size; siz > 0; ro++, siz--) {
						if (squares[column][ro].isOccupied()) {
							throw new SquareOccupiedException();
						} else if (siz == 1) {
							unOccupied = true;
						}
					}
					for (int siz = size; siz > 0; row++, siz--) {
						 if (unOccupied = true) {
								squares[column][row].placeShip(ship);
							}
					}
					ship.donePlacing();
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

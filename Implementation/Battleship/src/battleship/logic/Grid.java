package battleship.logic;

public interface Grid {
	
	public void placeShip(Ship ship, int column, int row, boolean isHorizontal);
	
	public Square shoot(int column, int row);

}

package battleship.logic;

import java.util.HashMap;

public class PlayerImp implements Player {

	private Player opponent;
	private Grid fleetGrid;
	private Grid targetGrid;
	private HashMap<String, Ship> ships;
	private String name;
	

	public PlayerImp(String name, Player opponent) {
		this.name = name;
		this.opponent = opponent;
		fleetGrid = new Grid();
		targetGrid = new Grid();
		ships = new HashMap<String, Ship>();
		ships.put("Carrier", new Ship(Carrier));
		ships.put("Battleship", new Ship(Battleship));
		ships.put("Cruiser", new Ship(Cruiser));
		ships.put("Submarine", new Ship(Submarine));
		ships.put("Destroyer", new Ship(Destroyer));
	}

	@Override
	public Square shoot(int column, int row) {
		return fleetGrid.shoot(column, row);
	}

	@Override
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) {
		if (ships.get(shipClass).isPlaced()) {
			throw new AlreadyPlacedException();
		} else {
			fleetGrid.placeShip(ships.get(shipClass), column, row, isHorizontal);
		}
	}

	@Override
	public Grid getTargetGrid() {
		return targetGrid;
	}

	@Override
	public Grid getFleetGrid() {
		return fleetGrid;
	}

	public String getName() {
		return name;
	}
}

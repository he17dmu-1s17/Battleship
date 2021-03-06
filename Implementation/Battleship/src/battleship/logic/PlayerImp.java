package battleship.logic;

import java.util.HashMap;

public class PlayerImp implements Player {

	private PlayerImp opponent;
	private GridImp fleetGrid;
	private GridImp targetGrid;
	private HashMap<ShipClass, Ship> ships;
	private String name;
	

	public PlayerImp(String name) {
		this.name = name;
		fleetGrid = new GridImp();
		targetGrid = new GridImp();
		ships = new HashMap<ShipClass, Ship>();

		// Generating ships
		for(ShipClass shipClass : ShipClass.values())
			ships.put(shipClass, new ShipImp(shipClass));
	}

	@Override
	public Square shoot(int column, int row) throws AlreadyShotException {
		return fleetGrid.shoot(column, row);
	}

	@Override
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) throws AlreadyPlacedException, OutOfBoundsException, SquareOccupiedException {
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

	@Override
	public boolean allShipsSunk() {
		for(Ship ship : ships.values())
			if(!ship.isSunk())
				return false;
		return true;
	}

	@Override
	public HashMap<ShipClass, Ship> getShips() {
		return ships;
	}

	public String getName() {
		return name;
	}

	

}

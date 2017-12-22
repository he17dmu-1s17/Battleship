package battleship.logic;

import java.util.HashMap;

public class PlayerImp implements Player {

	private PlayerImp opponent;
	private GridImp fleetGrid;
	private GridImp targetGrid;
	private HashMap<ShipClass, ShipImp> ships;
	private String name;
	

	public PlayerImp(String name) {
		this.name = name;
		fleetGrid = new GridImp();
		targetGrid = new GridImp();
		ships = new HashMap<ShipClass, ShipImp>();
		ships.put(ShipClass.Carrier, new ShipImp(ShipClass.Carrier));
		ships.put(ShipClass.Battleship, new ShipImp(ShipClass.Battleship));
		ships.put(ShipClass.Cruiser, new ShipImp(ShipClass.Cruiser));
		ships.put(ShipClass.Submarine, new ShipImp(ShipClass.Submarine));
		ships.put(ShipClass.Destroyer, new ShipImp(ShipClass.Destroyer));
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
		if(ships.get(ShipClass.Carrier).isSunk() && ships.get(ShipClass.Battleship).isSunk() && ships.get(ShipClass.Cruiser).isSunk() && ships.get(ShipClass.Submarine).isSunk() && ships.get(ShipClass.Destroyer).isSunk())
			return true;
		else
			return false;
	}

	@Override
	public HashMap<ShipClass, ShipImp> getShips() {
		return ships;
	}

	public String getName() {
		return name;
	}

}

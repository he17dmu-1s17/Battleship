package battleship.logic;

import java.util.HashMap;

public class PlayerImp implements Player {

	private Grid fleetGrid;
	private Grid targetGrid;
	private HashMap Ships;
	private String name;

	public PlayerImp(Grid fleetGrid, Grid targetGrid, HashMap Ships, String name) {
		this.fleetGrid = fleetGrid;
		this.targetGrid = targetGrid;
		this.Ships = Ships;
		this.name = name;
	}

	@Override
	public Square shoot(int column, int row) {
		return fleetGrid.shoot(column, row);
	}

	@Override
	public void getShotAt(int column, int row) {
		// Spoorg Anders
	}

	@Override
	public void placeShip(ShipClass shipClass, int column, int row, boolean isHorizontal) {
		if (Ships.get(shipClass).isPlaced()) {
			throw new AlreadyPlacedException();
		} else {
			fleetGrid.placeShip(Ships.get(shipClass), column, row, isHorizontal);
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

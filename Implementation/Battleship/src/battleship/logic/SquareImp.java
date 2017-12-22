package battleship.logic;

public class SquareImp implements Square {
	
	Ship ship;
	SquareStatus status;
	
	
	public boolean isOccupied() {
		return ship != null ? true : false;
	}

	@Override
	public void placeShip(Ship ship) throws SquareOccupiedException {
		if(isOccupied()) {
			// isoccupied exception
			throw new SquareOccupiedException();
		}else {
			this.ship=ship;
		}

	}

	@Override
	public void receiveShot() throws AlreadyShotException {
		if (ship != null) {
			if(SquareStatus.Untargeted != null) {
				ship.receiveDamage();
				ship.isSunk();
				if(ship.isSunk()) {
					// status = sunk
					status = SquareStatus.Sunk;
					
				}else {
					// status = hit
					status = SquareStatus.Hit;
				}
				
			}else {
				// alreadyshotexception
				throw new AlreadyShotException();
			}
		}else {
			// status = miss
			status = SquareStatus.Miss;
		}
	}

	@Override
	public SquareStatus getStatus() {
		
		return status;
	}

}
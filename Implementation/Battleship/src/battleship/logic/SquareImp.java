package battleship.logic;

public class SquareImp implements Square {
	
	Ship ship;
	SquareStatus status;
	
	
	public boolean isOccupied() {
		if(ship !=null) {
			return true;
		}else {
		return false;
		}
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
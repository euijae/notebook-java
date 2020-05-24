package codingproblems.ctci.ch7.q4;

public class Level {
	private int floor;
	private Spot[] spots;
	private int availableSpots = 0;
	private static final int SPOTS_PER_ROW = 10;

	public Level(int f, int numberSpots) {
		floor = f;
		spots = new Spot[numberSpots];
		int largeSpots = numberSpots / 4;
		int bikeSpots = numberSpots / 4;
		int compactSpots = numberSpots - largeSpots - bikeSpots;
		
		for (int i = 0; i < numberSpots; i++) {
			VehicleType sz = VehicleType.Motorcycle;
			if (i < largeSpots) {
				sz = VehicleType.Bus;
			} else if (i < largeSpots + compactSpots) {
				sz = VehicleType.Car;
			}
			int row = i / SPOTS_PER_ROW;
			spots[i] = new Spot(this, row, i, sz);
		}
		availableSpots = numberSpots;
	}
	
	/**
	 * Try to find a place to park this vehicle.
	 * Return false if failed.
	 */
	public boolean parkVehicle(Vehicle v) {
		if(getAvailableSpots() < v.getSpotsNeeded()) {
			return false;
		} 
		
		int spotNumber = findAvailableSpots(v);
		
		if(spotNumber < 0)
			return false;
		
		return parkStartingAtSpot(spotNumber, v);
	}
	
	/**
	 * Park a vehicle starting at the spot spotNumber.
	 * Continuing until v.spotNeeded
	 */
	private boolean parkStartingAtSpot(int spotNumber, Vehicle v) {
		int spotNeeded = v.getSpotsNeeded();
		v.clearSpots();
		boolean success = true;
		
		for(int i = spotNumber; i < spotNumber + spotNeeded; i++) {
			success &= spots[i].park(v);
		}
		
		if(success) {
			availableSpots -= v.getSpotsNeeded();
		}
		
		return success;
	}
	
	/**
	 * Find a spot to park this vehicle.
	 * Return index of the spot or -1 on failure. 
	 */
	private int findAvailableSpots(Vehicle v) {
		int spotsNeeded = v.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;
		
		for (int i = 0; i < spots.length; i++) {
			Spot spot = spots[i];
			if (lastRow != spot.getRow()) {
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			if (spot.canFitVehicle(v)) {
				spotsFound++;
			} else {
				spotsFound = 0;
			}
			if (spotsFound == spotsNeeded) {
				return i - (spotsNeeded - 1);
			}
		}
		return -1;		
	}
	
	public void print() {
	}
	
	public void spotFreed() {
		availableSpots++ ;
	}

	/**
	 * setters and getters
	 * @return
	 */
	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Spot[] getSpots() {
		return spots;
	}

	public void setSpots(Spot[] spots) {
		this.spots = spots;
	}

	public int getAvailableSpots() {
		return availableSpots;
	}

	public void setAvailableSpots(int availableSpots) {
		this.availableSpots = availableSpots;
	}
}

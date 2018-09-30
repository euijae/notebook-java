package go.there.soon.ctci.ch7.q4;

public class Spot {
	private Vehicle vehicle;
	private VehicleType vehicleType;
	private int row;
	private int spotNumber;
	private Level level;
	
	public Spot(Level l, int r, int n, VehicleType vt) {
		vehicle = null;
		level = l;
		row = r;
		spotNumber = n;
		vehicleType = vt;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle(Vehicle v) {
		return isAvailable() && v.canFitSpots(this);
	}
	
	public boolean park(Vehicle v) {
		if(!canFitVehicle(v)) {
			return false;
		}
		
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}

	public void print() {
		if(vehicle != null) {
			if(vehicleType == VehicleType.Motorcycle)
				System.out.println("Motorcycle");
			else if(vehicleType == VehicleType.Car)
				System.out.println("Car");
			else if(vehicleType == VehicleType.Bus)
				System.out.println("Bus");
		} else {
			vehicle.print();
			return;
		}
	}
	
	/**
	 * setters and getters
	 * @return
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}

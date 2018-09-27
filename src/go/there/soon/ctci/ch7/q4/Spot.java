package go.there.soon.ctci.ch7.q4;

public class Spot {
	private boolean isAvailable;
	private Vehicle vehicle;
	protected SpotType type;
	
	public Spot() {
		isAvailable = true;
		vehicle = null;
	}
	
	public void removeVehicle() {
		vehicle = null;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public SpotType getType() {
		return type;
	}

	public void setType(SpotType type) {
		this.type = type;
	}
}

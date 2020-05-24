package codingproblems.ctci.ch7.q4;

import java.util.List;

abstract class Vehicle {
	private String plate;
	private List<Spot> spots;
	private int spotsNeeded;
	private VehicleType vehicleType;
	
	public Vehicle() {}
	
	public void parkInSpot(Spot spot) {
		spots.add(spot);
	}
	
	public void clearSpots() {
		for(int i = 0; i < spots.size(); i++) {
			spots.get(i).removeVehicle();
		}
		spots.clear();
	}
	
	public Vehicle(String p) {
		plate = p;
	}
	
	abstract boolean canFitSpots(Spot spot);
	abstract void print();

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public List<Spot> getSpots() {
		return spots;
	}

	public void setSpots(List<Spot> spots) {
		this.spots = spots;
	}

	public int getSpotsNeeded() {
		return spotsNeeded;
	}

	public void setSpotsNeeded(int spotsNeeded) {
		this.spotsNeeded = spotsNeeded;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}

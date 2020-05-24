package codingproblems.ctci.ch7.q4;

public class Bus extends Vehicle {

	public Bus() {
		setSpotsNeeded(5);
		setVehicleType(VehicleType.Bus);
	}
	
	@Override
	boolean canFitSpots(Spot spot) {
		return spot.getVehicleType() == VehicleType.Bus;
	}

	@Override
	void print() {
		System.out.println("Bus");
	}
}

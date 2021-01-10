package codingproblems.ctci.ch7.q4;

public class Car extends Vehicle {

	public Car() {
		setSpotsNeeded(1);
		setVehicleType(VehicleType.Car);
	}

	@Override
	boolean canFitSpots(Spot spot) {
		return spot.getVehicleType() == VehicleType.Car
				|| spot.getVehicleType() == VehicleType.Bus;
	}

	@Override
	void print() {
		System.out.println("Car");
	}
}

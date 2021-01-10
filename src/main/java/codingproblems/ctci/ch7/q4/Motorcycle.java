package codingproblems.ctci.ch7.q4;

public class Motorcycle extends Vehicle {

	public Motorcycle() {
		setSpotsNeeded(1);
		setVehicleType(VehicleType.Motorcycle);
	}

	@Override
	boolean canFitSpots(Spot spot) {
		return true;
	}

	@Override
	void print() {
		System.out.println("Motorcycle");
	}
}

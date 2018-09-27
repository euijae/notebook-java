package go.there.soon.ctci.ch7.q4;

import java.util.List;

abstract class Vehicle {
	private String plate;
	private List<Spot> spots;
	
	/** setters and getters */
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
}

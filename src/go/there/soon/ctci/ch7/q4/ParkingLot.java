package go.there.soon.ctci.ch7.q4;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private List<Level> levels;
	private final int NUM_LEVELS = 5;

	public ParkingLot() {
		levels = new ArrayList<>();
		for(int i = 0; i < NUM_LEVELS; i++) {
			levels.add(new Level(i, 30));
		}
	}
	
	public boolean parkVehicle(Vehicle v) {
		for(int i = 0; i < levels.size(); i++) {
			if(levels.get(i) == null) {
				return true;
			}
		}
		
		return false;
	}
	
	public void print() {
		
	}
	
	/**
	 * setters and getters
	 * @return
	 */
	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
}

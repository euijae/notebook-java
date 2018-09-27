package go.there.soon.ctci.ch7.q4;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	private List<Level> levels;

	public ParkingLot() {
		levels = new ArrayList<>();
	}
	
	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
}

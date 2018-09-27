package go.there.soon.ctci.ch7.q4;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Level level1 = new Level();
		List<Row> rows1 = new ArrayList<>();
		rows1.add(new Row(1, 3, 3, 5));
		rows1.add(new Row(2, 4, 5, 2));
		rows1.add(new Row(3, 1, 2, 8));
		level1.setRows(rows1);
		
		Level level2 = new Level();
		List<Row> rows2 = new ArrayList<>();
		rows2.add(new Row(1, 3, 3, 15));
		rows2.add(new Row(2, 5, 5, 5));
		level2.setRows(rows2);
		
		List<Level> levels = new ArrayList<>();
		levels.add(level1);
		levels.add(level2);
		
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.setLevels(levels);
		
		
	}

}

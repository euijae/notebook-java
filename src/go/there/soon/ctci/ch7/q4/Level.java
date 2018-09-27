package go.there.soon.ctci.ch7.q4;

import java.util.ArrayList;
import java.util.List;

public class Level {
	private List<Row> rows;

	public Level() {
		rows = new ArrayList<>();
	}
	
	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
}

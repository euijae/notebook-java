package go.there.soon.ctci.ch7.q4;

public class Row {
	private Spot [] spots;
	private int whichRow;
	
	private int numM;
	private int numC;
	private int numL;
	
	public Row(int r, int m, int c, int l) {
		whichRow = r;
		numM = m;
		numC = c;
		numL = l;
		
		spots = new Spot[m + c + l];
		
		int i = 0;
		
		for(; i < m; i++)
			spots[i].setType(SpotType.Motocycle);
		
		for(; i < m + c; i++)
			spots[i].setType(SpotType.Compact);
		
		for(; i < m + c + l; i++) 
			spots[i].setType(SpotType.Large);
	}
	
	public void parkIn(Vehicle v) {
		
	}
	
	public void parkOut(Vehicle v) {
		int [] spots_local = {};
		
		for(int i = 0; i < spots_local.length; i++) {
			int at = spots_local[i];
			spots[at] = null;
		}
	}
	
	public void isAvailable(Vehicle v) {
		
	}
	
	/** setters and getters */
	public int getWhichRow() {
		return whichRow;
	}

	public void setWhichRow(int whichRow) {
		this.whichRow = whichRow;
	}
	
	public Spot[] getSpots() {
		return spots;
	}

	public void setSpots(Spot[] spots) {
		this.spots = spots;
	}

	public int getNumM() {
		return numM;
	}

	public void setNumM(int numM) {
		this.numM = numM;
	}

	public int getNumC() {
		return numC;
	}

	public void setNumC(int numC) {
		this.numC = numC;
	}

	public int getNumL() {
		return numL;
	}

	public void setNumL(int numL) {
		this.numL = numL;
	}
}

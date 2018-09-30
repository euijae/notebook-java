package go.there.soon.ctci.ch7.q4;

@Deprecated
public class Row {
	private Spot [] spots;
	private int whichRow;
	
	private int numS;
	private int numC;
	private int numL;
	
	public Row(int r, int s, int c, int l) {
		whichRow = r;
		numS = s;
		numC = c;
		numL = l;
		
		spots = new Spot[s + c + l];
	}
	
	public boolean isAvailable() {
		for(int i = 0; i < spots.length; i++)
			if(spots[i].isAvailable())
				return true;
		
		return false;
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

	public int getNumS() {
		return numS;
	}

	public void setNumS(int numS) {
		this.numS = numS;
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

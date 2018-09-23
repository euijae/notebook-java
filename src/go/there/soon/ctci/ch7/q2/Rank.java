package go.there.soon.ctci.ch7.q2;

public enum Rank {
	Respondent (1),
	Manager		(2),
	Director		(3);
	
	private int rank;
	
	private Rank(int r) {
		rank = r;
	}
	
	public int getRank() {
		return rank;
	}
}

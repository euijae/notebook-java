package codingproblems.ctci.ch7.q1;

public abstract class Card {
	private boolean available = true;

	protected int faceValue;
	protected Suit suit;

	public Card(int faceValue, Suit suit) {
		this.faceValue = faceValue;
		this.suit = suit;
	}

	public abstract int value();

	public Suit suit() {
		return suit;
	}

	public boolean isAvailable() {
		return available;
	}

	public void markUnavailable() {
		available = false;
	}

	public void markAvailable() {
		available = true;
	}

	public void print() {
		String [] faceValues = {
				"A", "2", "3", "4", "5",
				"6", "7", "8", "9", "10",
				"J", "Q", "K"
		};
		System.out.print(faceValues[faceValue-1]);
		switch(suit) {
			case Club:
				System.out.print("c");
				break;
			case Heart:
				System.out.print("h");
				break;
			case Diamond:
				System.out.print("d");
				break;
			case Spade:
				System.out.print("s");
				break;
		}
		System.out.print(" ");
	}
}

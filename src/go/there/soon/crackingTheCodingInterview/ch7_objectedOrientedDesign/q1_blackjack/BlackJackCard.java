package go.there.soon.crackingTheCodingInterview.ch7_objectedOrientedDesign.q1_blackjack;

public class BlackJackCard extends Card{
	public BlackJackCard(int c, Suit s) {
		super(c, s);
	}

	@Override
	public int value() {
		if(isAce())
			return 1;
		else if(faceValue >= 11 && faceValue <= 13)
			return 10;
		else
			return faceValue;
	}
	
	public int minValue() {
		return (isAce()) ? 1 : value();
	}
	
	public int maxValue() {
		return (isAce()) ? 11 : value();
	}
	
	public boolean isAce() {
		return faceValue == 1;
	}
	
	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
}

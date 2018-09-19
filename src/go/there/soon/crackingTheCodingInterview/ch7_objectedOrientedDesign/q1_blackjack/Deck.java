package go.there.soon.crackingTheCodingInterview.ch7_objectedOrientedDesign.q1_blackjack;

import java.util.ArrayList;

import go.there.soon.crackingTheCodingInterview.library.AssortedMethods;

public class Deck <T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0;
	
	public Deck() {}
	
	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		cards = deckOfCards;
	}
	
	public void shuffle() {
		for(int i = 0; i < cards.size(); i++) {
			int j = AssortedMethods.randomIntInRange(i, cards.size() - i - 1);
			T card1 = cards.get(i);
			T card2 = cards.get(j);
			cards.set(i, card2);
			cards.set(j, card1);
		}
	}
	
	public int remainingCards() {
		return cards.size() - dealtIndex;
	}
	
	public T[] dealHand(int number) {
		if(remainingCards() < number) 
			return null;
		
		@SuppressWarnings("unchecked")
		T[] hand = (T[]) new Card[number];
		int count = 0;
		while(count < number) {
			T card = dealCard();
			if(card != null) {
				hand[count] = card;
				count ++;
			}
		}
		
		return hand;
	}
	
	public T dealCard() {
		if(remainingCards() == 0 || dealtIndex > cards.size()-1)
			return null;
		
		T card = cards.get(dealtIndex);
		card.markUnavailable();
		dealtIndex++;
		
		return card;
	}
	
	public void print() {
		for(Card card : cards) {
			card.print();
		}
	}
}
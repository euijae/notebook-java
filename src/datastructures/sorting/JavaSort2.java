package datastructures.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class JavaSort2 {

	public static void main(String[] args) {
		//sort an array of cards by using the Comparable interface
		String[] suits = {"Diamonds", "Hearts", "Spades", "Clubs"};
		Card[] hand = new Card[5];
		Random rand = new Random();
		
		for (int i = 0; i < 5; i++)
			hand[i] = new Card(suits[rand.nextInt(4)], rand.nextInt(12));

		System.out.println("(suit, value):  ");
		System.out.println(Arrays.toString(hand));
		
		System.out.println("\nsort by value");
		Arrays.sort(hand);
		System.out.println(Arrays.toString(hand));
		
		//sort an array of cards by using the Comparator
		Arrays.sort(hand, new SuitSort());
		System.out.println("\nsort by suit");
		System.out.println(Arrays.toString(hand));
		
		
	}

}

class Card implements Comparable<Card> {

	private String suit;
	private int value;
	
	public Card(String suit, int value){
		this.suit = suit;
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public String getSuit() {
		return suit;
	}
	public String toString()
	{
		return "(" + suit + "," + value +")";
	}
	
	@Override
	public int compareTo(Card o) {
		return this.getValue() - o.getValue();
	}
}

class SuitSort implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		return o1.getSuit().compareToIgnoreCase(o2.getSuit());
	}
	
}

class SuitValue implements Comparator<Card> {

	@Override
	public int compare(Card x, Card y) {
		int n = x.getSuit().compareTo( y.getSuit() );
		if( n != 0 )
			return n;
		else
			return x.getValue() - y.getValue();
	}
}
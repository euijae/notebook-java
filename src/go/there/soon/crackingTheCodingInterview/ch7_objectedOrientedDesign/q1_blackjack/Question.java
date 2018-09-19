package go.there.soon.crackingTheCodingInterview.ch7_objectedOrientedDesign.q1_blackjack;

import java.util.ArrayList;

public class Question {
	public static void main(String [] args) {
		int numHands = 5;
		
		BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
		automator.initializeDeck();
		
		boolean success = automator.dealInitial();
		
		if(!success) {
			System.out.println("Error. Out of cards.");
		} else {
			System.out.println("-- Initial --");
			automator.printHandsAndScore();
			ArrayList<Integer> blackjacks = automator.getBlackJacks();
			
			if(blackjacks.size() > 0) {
				System.out.print("Blackjack at ");
				for(int i : blackjacks)
					System.out.print(i + ", ");
				System.out.println("");
			} else {
				success = automator.playAllHands();
				automator.printHandsAndScore();
				ArrayList<Integer> winners = automator.getWinners();
				
				if(winners.size() > 0) {
					System.out.print("Winners: ");
					for(int i : winners) {
						System.out.print(i + ", ");
					}
					System.out.println("");
				} else {
					System.out.println("Draw. All players have busted.");
				}
			}
		}
	}
}

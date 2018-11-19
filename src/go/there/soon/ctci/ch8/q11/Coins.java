package go.there.soon.ctci.ch8.q11;

/**
 * incomplete as of 11/19/2018
 * @author euijae_kim
 *
 */
public class Coins {

	public static void main(String[] args) {
		int total = coins(20);
		System.out.println(total);
	}
	
	public static int coins(int target) {
		int [] coins = {25, 10, 5, 1};
		int count = 0;
		
		int index = getIndex(coins, target); // correct
		
		if(index != -1) {
			for(int i = index; i < coins.length; i++) {
				int maxMultiplier = target / coins[i]; // correct
				count += coinsHelper(coins, i, maxMultiplier, 0, target);
				System.out.print("at: " + i + ", coin: " + coins[i]);
				System.out.print(", multiplier: " + maxMultiplier);
				System.out.println(", count: " + count);
			}
		}
		
		return count;
	}
	
	public static int coinsHelper(int [] coins, int index, int mult, int sub, int target) {
		if(sub > target || coins.length <= index || mult < 0) // correct
			return 0;
		
		if(coins[index] == 1) // correct
			return 1;
		
		if(mult == 0) {
			index ++;
			mult = sub / coins[index];
			return coinsHelper(coins, index, mult, sub, target) + (sub == target ? 1 : 0);
		}
		
		if(sub == target) {
			return 1 + coinsHelper(coins, index, mult, sub - (mult+1) * coins[index], target);
		}
		
		return coinsHelper(coins, index, --mult, sub + ((mult+1) * coins[index]), target);
	}
	
	public static int getIndex(int [] coins, int target) {
		for(int i = 0; i < coins.length; i++) {
			if(coins[i] <= target)
				return i;
		}
		
		return -1;
	}
}

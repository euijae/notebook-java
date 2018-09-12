package go.there.soon.geekForGeeks.practice.string;

/**
 * https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
 * Given a string, find all possible palindrome partitions of given string.
 * @author eugene.kim
 *
 */
public class PalindromicPartitions {
	
	private String str;
	
	public PalindromicPartitions(String str) {
		this.setStr(str);
	}
	
	public static void main(String[] args) {
		String str = "nitin";
		PalindromicPartitions p = new PalindromicPartitions(str);
		p.getStr();
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}

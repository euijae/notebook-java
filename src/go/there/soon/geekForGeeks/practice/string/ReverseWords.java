package go.there.soon.geekForGeeks.practice.string;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
 * @author euijaekim
 *
 */
public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWords rw = new ReverseWords();
		rw.test();
	}
	
	public void test() {
		String str = "i.like.this.program.very.much";
		System.out.printf("%s - %s\n", str, reverse(str));
	}
	
	public String reverse(String str) {
		char [] arr = str.toCharArray();
		
		reverse(arr, 0, arr.length-1);
		int p1 = 0;
		int p2 = 0;
		
		while(p2 < arr.length) {
			while(p2 < arr.length && arr[p2] != '.') p2++;
			if(p2 < arr.length) {
				reverse(arr, p1, p2-1);
				p1 = p2 + 1;
				p2 = p1;
			}
		}
		
		reverse(arr, p1, p2-1);
		
		return String.valueOf(arr);
	}
	
	public void reverse(char [] arr, int left, int right) {
		while(left < right) {
			char c = arr[left];
			arr[left] = arr[right];
			arr[right] = c;
			left ++;
			right --;
		}
	}
}

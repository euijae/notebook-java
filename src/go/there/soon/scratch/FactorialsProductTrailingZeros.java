package go.there.soon.scratch;

public class FactorialsProductTrailingZeros {

	public static void main(String[] args) {
		FactorialsProductTrailingZeros f = new FactorialsProductTrailingZeros();
		f.test();
		System.out.println("Done");
	}
	
	public void test() {
		int ans = factorialsProductTrailingZeros(4, 10);
		System.out.println(ans);
	}
	
	public int factorialsProductTrailingZeros(int l, int r) {
	    int counter = 0;
	    int f = 1;
	    for(int i = l; i <= r; i++) {
	        f *= factorial(i);
	        
	        while(f % 10 == 0) {
	            counter++;
	            f /= 10;
	        }
	        System.out.printf("counter: %d, f: %d\n", counter, f);
	    }
	    
	    return counter;
	}

	public int factorial(int n) {
	    int f = 1;
	    
	    for(int i = 1; i<=n; i++) {
	        f = f*i;
	    }
	    return f;
	}

}

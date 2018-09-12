package go.there.soon.geekForGeeks.practice.dynamicProgramming;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(40));
	}
	
	public static int fibonacci(int n) {
		int [] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		fib[2] = 1;
		
		for(int i = 3; i <= n; i++)
			fib[i] = fib[i-1] + fib[i-2];
		
		return fib[n];
	}
}

package codingproblems.geekForGeeks.practice;

/**
 * https://practice.geeksforgeeks.org/problems/count-of-strings-that-can-be-formed-using-a-b-and-c-under-given-constraints/0
 * @author eugene.kim
 *
 */
public class CountStrings {

	public int counter(int N) {
		return (1 + 2*N + N*(N-1) * (N+1) / 2);
	}
}

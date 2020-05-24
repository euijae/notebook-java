package codingproblems.ctci.ch8.q9;

import java.util.*;

public class Parens2 {

    public static void main(String [] args) {
        List<String> ans = parens(1);
        System.out.println(ans.toString());
    }

    public static List<String> parens(int N) {
        List<String> ans = new ArrayList<>();
        parens(N, 0, 0, ans, "");
        return ans;
    }

    public static void parens(int N, int left, int right, List<String> lists, String str) {
        if(left == N && right == N) {
            lists.add(str);
        }

        if(left < right || left > N || right > N) {
            return ;
        }

        parens(N, left + 1, right, lists, str + '(');
        parens(N, left, right + 1, lists, str + ')');
    }
}

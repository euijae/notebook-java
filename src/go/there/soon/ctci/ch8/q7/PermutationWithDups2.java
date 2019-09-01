package go.there.soon.ctci.ch8.q7;

import java.util.*;

public class PermutationWithDups2 {
    public static void main(String [] args) {
        LinkedList<String> ans = permutation("abcd");
        System.out.printf("there are %d and the lists are ...\n%s", ans.size(), ans.toString());
    }

    public static LinkedList<String> permutation(String str) {
        LinkedList<String> ans = new LinkedList<>();

        for(char ch : str.toCharArray()) {
            int size = ans.size();

            if(size == 0) {
                ans.add(""+ch);
            } else {
                for(int i = 0; i < size; i++) {
                    String word = new String(ans.removeFirst());

                    int len = word.length();

                    for(int j = 0; j <= len; j++) {
                        String before = word.substring(0, j);
                        String after = word.substring(j);
                        ans.addLast(before + ch + after);
                    }
                }
            }
        }

        return ans;
    }
}

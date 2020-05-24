package codingproblems.ctci.ch8.q8;

import java.util.*;

public class PermutationWithDups2 {
    public static void main(String [] args) {

        String str = "aabb";
        LinkedList<String> ans = permutations(str);
        System.out.println(ans.toString());
    }

    public static LinkedList<String> permutations(String str) {
        LinkedList<String> ans = new LinkedList<>();
        Set<String> dupChecker = new HashSet<>();

        for(char ch : str.toCharArray()) {
            int size = ans.size();

            if(ans.isEmpty()) {
                ans.add("" + ch);
            } else {
                for(int i = 0; i < size; i++) {
                    String word = ans.removeFirst();

                    for(int j = 0; j <= word.length(); j++) {
                        String before = word.substring(0, j);
                        String after = word.substring(j);

                        if(j != 0 && word.charAt(j-1) == ch) {
                            continue;
                        } else {
                            String permutationWord = before + ch + after;
                            if(!dupChecker.contains(permutationWord)) {
                                ans.add(permutationWord);
                                dupChecker.add(permutationWord);
                            }

                        }
                    }
                }
            }
        }

        return ans;
    }
}

package codingproblems.educative.math;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {

    public static void main(String [] args) {
        String word = "abc";

        List<String> lists1 = permutation(word);
        System.out.println(lists1.toString());
    }

    public static List<String> permutation(String word) {
        List<String> permutations = new ArrayList<>();
        permutation(permutations, word, "");

        return permutations;
    }

    public static void permutation(List<String> lists,
                                   String prefix,
                                   String suffix) {
        if(prefix.isEmpty()) {
            lists.add(suffix);
        } else {
            for(int i = 0; i < prefix.length(); i++) {
                if(i > 0 && prefix.charAt(i) == prefix.charAt(i-1)) {
                    continue;
                } else {
                    String reducedPrefix = prefix.substring(0, i) + prefix.substring(i+1); // bd
                    char currentCharacter = prefix.charAt(i); // a
                    permutation(lists, reducedPrefix, suffix + currentCharacter);
                }
            }
        }
    }
}

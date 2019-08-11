package go.there.soon.scratch.onsite;

import java.util.*;

public class PhoneCombinations {

    public static void main(String [] args) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        LinkedList<String> list = new LinkedList<>();
        list.add("");

        String digits = "23";

        for(char digit : digits.toCharArray()) {
            if(map.containsKey(digit)) {
                String assignedAlphabets = map.get(digit);

                int size = list.size();

                for(int i = 0; i < size; i++) {
                    String prev = list.remove(i);

                    for(char ch : assignedAlphabets.toCharArray()) {
                        list.add(prev + ch);
                    }
                }
            }
        }

        for(String str : list) {
            System.out.println(str);
        }

        System.out.println(list.size());
    }
}

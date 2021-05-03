package main.java.codingproblems.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]],
 *          ruleKey = "color",
 *          ruleValue = "silver"
 *  Output: 1
 *  Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 */
class CountMatches {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);

        for(int i = 0; i < items.size(); i++) {
            List<String> item = items.get(i);

            if(map.containsKey(ruleKey)) {
                int index = map.get(ruleKey);
                counter += (item.get(index).equals(ruleValue) ? 1: 0);
            }
        }

        return counter;
    }
}

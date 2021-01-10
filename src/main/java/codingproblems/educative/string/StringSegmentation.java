package codingproblems.educative.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringSegmentation {

    public static void main(String [] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("pear");
        set.add("pie");
        set.add("pier");

        String word = "applepeer";

        StringSegmentation ss = new StringSegmentation();
        System.out.println(ss.test(set, word));
    }

    public boolean test(Set<String> words, String word) {
        Trie trie = new Trie();

        for(String s : words)
            trie.insert(s);

        int start = 0;
        int end = 1;

        while(end <= word.length()) {
            String str = word.substring(start, end);

            if(trie.isFound(str)) {
                if(trie.isEnd(str)) {
                    start = end;
                }

                end++;
            } else {
                return false;
            }
        }

        return true;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode runner = root;

        for(char key : word.toCharArray()) {
            if(!runner.children.containsKey(key)) {
                runner.children.put(key, new TrieNode());
            }

            runner = runner.children.get(key);
        }

        runner.isEnd = true;
    }

    public boolean isFound(String word) {
        TrieNode runner = root;

        for(char key : word.toCharArray()) {
            if(!runner.children.containsKey(key))
                return false;

            runner = runner.children.get(key);
        }

        return true;
    }

    public boolean isEnd(String word) {
        TrieNode runner = root;

        for(char key : word.toCharArray()) {
            if(!runner.children.containsKey(key))
                return false;

            runner = runner.children.get(key);
        }

        return runner.isEnd;
    }
}

class TrieNode {
    public char key;
    public Map<Character, TrieNode> children;
    public boolean isEnd;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEnd = false;
    }

    public TrieNode(char key) {
        this.key = key;
        this.children.put(key, new TrieNode());
    }
}
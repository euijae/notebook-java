package go.there.soon.scratch.onsite.autocomplete;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children;
    char data;
    String word;
    boolean isEnd;

    public TrieNode() {
        children = new HashMap<>();
        this.word = "";
        this.isEnd = false;
    }

    public TrieNode(char data) {
        this();
        this.data = data;
        this.word = String.valueOf(data);
    }
}

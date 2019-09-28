package go.there.soon.scratch.onsite.autocomplete;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getLastNodeOfPrefix(String query) {
        TrieNode runner = root;

        for(char key : query.toCharArray()) {
            if(!runner.children.containsKey(key))
                return null;

            runner = runner.children.get(key);
        }

        return runner;
    }

    public List<String> autocomplete(String query) {
        TrieNode lastNodeOfPrefix = getLastNodeOfPrefix(query);
        List<String> result = new ArrayList<>();

        LinkedList<TrieNode> nodesByLevel = new LinkedList<>();
        nodesByLevel.add(lastNodeOfPrefix);

        while(!nodesByLevel.isEmpty()) {
            TrieNode top = nodesByLevel.removeFirst();

            for(TrieNode node : top.children.values()) {
                nodesByLevel.add(node);

                if(node.isEnd) {
                    result.add(node.word);
                }
            }
        }

        return result;
    }

    public void insert(String word) {
        TrieNode runner = root;

        for(char ch : word.toCharArray()) {
            if(!runner.children.containsKey(ch)) {
                runner.children.put(ch, new TrieNode());
            }

            String prevWord = runner.word;
            runner = runner.children.get(ch);
            runner.word = prevWord + ch;
        }

        runner.isEnd = true;
    }

    public boolean isCompleteWord(String word) {
        TrieNode runner = root;

        for(char ch : word.toCharArray()) {
            if(!runner.children.containsKey(ch))
                return false;

            runner = runner.children.get(ch);
        }

        return runner.isEnd;
    }

    public boolean contains(String word) {
        TrieNode runner = root;

        for(char ch : word.toCharArray()) {
            if(!runner.children.containsKey(ch))
                return false;

            runner = runner.children.get(ch);
        }

        return true;
    }
}

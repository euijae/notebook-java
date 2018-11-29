package go.there.soon.scratch;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public char ch;
	public Map<Character, TrieNode> children;
	public boolean isWord;
	
	public TrieNode(char ch) {
		this.ch = ch;
		this.children = new HashMap<>();
	}
}

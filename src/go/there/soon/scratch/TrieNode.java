package go.there.soon.scratch;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public Character represent;
	public Map<Character, TrieNode> children;
	public boolean isWord;
	public boolean isEnd;
	
	public TrieNode(Character ch) {
		represent = new Character(ch);
		children = new HashMap<>();
	}
}

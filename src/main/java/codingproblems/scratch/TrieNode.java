package codingproblems.scratch;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	public char ch;
	public Map<Character, TrieNode> children;
	public boolean isWord;
	public boolean isEnd;
	public String word;
	
	public TrieNode() {
		this.isWord = false;
		this.isEnd = false;
		this.word = "";
	}
	
	public TrieNode(char ch) {
		this.ch = ch;
		this.children = new HashMap<>();
	}
}

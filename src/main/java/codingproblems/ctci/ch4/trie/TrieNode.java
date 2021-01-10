package codingproblems.ctci.ch4.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private Map<Character, TrieNode> next;
	private char data;
	private boolean isComplete;
	private boolean isWord;
	
	public TrieNode(char data) {
		this.data = data;
		this.next = new HashMap<>();
		this.isComplete = false;
		this.isWord = false;
	}

	public Map<Character, TrieNode> getNext() {
		return next;
	}

	public void setNext(Map<Character, TrieNode> next) {
		this.next = next;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public boolean isWord() {
		return isWord;
	}

	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
}

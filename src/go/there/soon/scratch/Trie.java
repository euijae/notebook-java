package go.there.soon.scratch;

public class Trie {
	public TrieNode root;
	
	public Trie() {
		root = new TrieNode(Character.MIN_VALUE);
	}
	
	public void insert(String str) {
		TrieNode node = root;
		for(int i = 0; i < str.length(); i++) {
			Character key = str.charAt(i);
			if(!node.children.containsKey(key)) 
				node.children.put(key, new TrieNode(key));
			node = node.children.get(key);
			
			if(i == str.length() -1) {
				node.isEnd  = true;
				node.isWord = true;
			}
		}
	}
	
	public boolean search(String str) {
		TrieNode node = root;
		for(int i = 0; i < str.length(); i++) {
			Character key = str.charAt(i);

			if(!node.children.containsKey(key))
				return false;
			
			node = node.children.get(key);
		}
		
		return node.isWord;
	}
	
	public boolean startsWith(String str) {
		TrieNode node = root;
		for(int i = 0; i < str.length(); i++) {
			Character key = str.charAt(i);

			if(!node.children.containsKey(key))
				return false;
			
			node = node.children.get(key);
		}
		
		return true;
	}
}

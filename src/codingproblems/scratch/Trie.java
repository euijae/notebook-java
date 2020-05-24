package codingproblems.scratch;

public class Trie {
	public TrieNode root;
	
	public Trie() {
		root = new TrieNode(Character.MIN_VALUE);
	}
	
	public void insert(String str) {
		TrieNode temp = root;
		
		for(int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			
			String word = temp.word == null ? "" : temp.word;
			
			if(!temp.children.containsKey(key)) {
				temp.children.put(key, new TrieNode(key));
			}
			
			temp = temp.children.get(key);
			temp.word = word + key;
			System.out.println(temp.word);
		}
		
		temp.isWord = true;
	}
	
	public boolean search(String str) {
		TrieNode temp = root;
		
		for(int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			
			if(!temp.children.containsKey(key)) {
				return false;
			}
			
			temp = temp.children.get(key);
		}
		
		return temp.isWord;
	}
	
	public boolean startsWith(String str) {
		TrieNode temp = root;
		
		for(int i = 0; i < str.length(); i++) {
			char key = str.charAt(i);
			
			if(!temp.children.containsKey(key)) {
				return false;
			}
			
			temp = temp.children.get(key);
		}
		
		return true;
	}
}

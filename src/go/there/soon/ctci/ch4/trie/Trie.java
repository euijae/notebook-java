package go.there.soon.ctci.ch4.trie;

public class Trie {
	public TrieNode root;
	
    /** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode(Character.MIN_VALUE);
	}
	
    /** Inserts a word into the trie. */
    public void insert(String word) {
    		TrieNode tempRoot = root;
    		
    		for(int i = 0; i < word.length(); i++) {
    			char ch = word.charAt(i);
    			if(tempRoot.getNext().get(ch) == null)
    				tempRoot.getNext().put(ch, new TrieNode(ch));
    			tempRoot = tempRoot.getNext().get(ch);
    			
    			if(i == word.length()-1) {
    				tempRoot.setComplete(true);
    				tempRoot.setWord(true);
    			}
    		}
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    		TrieNode tempRoot = root;
        for(int i = 0; i < word.length(); i++) {
        		char ch = word.charAt(i);
	        	if(tempRoot.getNext().get(ch) == null)
	    			return false;
	    		tempRoot = tempRoot.getNext().get(ch);
        }
        
        return tempRoot.isWord();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tempRoot = root;
        for(int i = 0; i < prefix.length(); i++) {
        		char ch = prefix.charAt(i);
	        	if(tempRoot.getNext().get(ch) == null)
	    			return false;
	    		tempRoot = tempRoot.getNext().get(ch);
        }
        
        return true;
    }
}

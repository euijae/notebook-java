package go.there.soon.leetCode.trie;

import java.util.*;

public class ReplaceWords {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		String word = "abcd";
		int index = 0;
		
		permutation(list, word, index);
		
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	public static void permutation(List<String> list, String word, int index) {
		if(index < word.length()) {
			append(list, word.charAt(index));
			permutation(list, word, index+1);
		}
	}
	
	public static void append(List<String> list, char ch) {
		if(list.isEmpty()) {
			list.add(String.valueOf(ch));
		} else {
			List<String> tempList = new ArrayList<>();
			for(String str : list) {
				for(int i = str.length(); i >= 0; i--) {
					String appended = str.substring(0, i) + ch + str.substring(i);
					tempList.add(appended);
				}
			}
			
			list.clear();
			list.addAll(tempList);
		}
	}
	
	class Solution {
	    
	    private Trie trie = new Trie();
	    
	    public String replaceWords(List<String> dict, String sentence) {
	        if(dict.size() <= 0 || sentence.isEmpty())
	            return "";
	        
	        for(String str : dict) {
	            trie.insert(str);
	        }
	        
	        String [] sentences = sentence.split(" ");
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < sentences.length; i++) {
	            sb.append(trie.reduceWord(sentences[i]));
	            
	            if(i < sentences.length - 1)
	                sb.append(" ");
	        }
	        
	        return sb.toString();
	    }
	    
	    
	    
	    class TrieNode {
	        Map<Character, TrieNode> children = new HashMap<>();
	    }
	    
	    class Trie {
	        private TrieNode root;
	        
	        public Trie() {
	            root = new TrieNode();
	        }
	        
	        public String reduceWord(String word) {
	            for(int i = 1; i <= word.length(); i++) {
	                String sub = word.substring(0, i);
	                
	                if(isStartsWith(sub))
	                    return sub;
	            }
	            
	            return word;
	        }
	        
	        public void insert(String word) {
	            TrieNode start = root;
	            
	            for(char key : word.toCharArray()) {
	                TrieNode next = start.children.getOrDefault(key, new TrieNode());
	                start.children.put(key, next);
	                start = next;
	            }
	        }
	        
	        public boolean isStartsWith(String word) {
	            TrieNode start = root;

	            for(char key : word.toCharArray()) {
	                if(!start.children.containsKey(key))
	                    return false;
	                
	                start = start.children.get(key);
	            }
	            
	            return true;
	        }
	    }
	}
}

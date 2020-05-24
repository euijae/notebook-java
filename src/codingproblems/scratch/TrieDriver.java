package codingproblems.scratch;

public class TrieDriver {

	public static void main(String[] args) {
		Trie trie = new Trie();
		String [] strings = {"cat", 
				"cell", 
				"cert", 
				"clean", 
				"cream"};
		
		for(String string : strings)
			trie.insert(string);
		
		System.out.println(trie.startsWith("zcl"));
	}
}

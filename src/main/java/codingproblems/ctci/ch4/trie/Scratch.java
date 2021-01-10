package codingproblems.ctci.ch4.trie;

public class Scratch {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
	}

}

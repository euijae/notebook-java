package go.there.soon.scratch.onsite.autocomplete;

import java.util.List;

public class Autocomplete {
    public static void main(String [] args) {
        Trie trie = new Trie();
        trie.insert("spring1");
        trie.insert("spring2");
        trie.insert("spring3");

        List<String> lists = trie.autocomplete("spring");

        for(String str : lists)
            System.out.println(str);
    }
}

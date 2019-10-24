package go.there.soon.scratch.practice.autocomplete;

import java.util.List;

public class Autocomplete {
    public static void main(String [] args) {

        Trie t = new Trie();
        t.insert("amazon");
        t.insert("amazon prime");
        t.insert("amazing");
        t.insert("amazing spider man");
        t.insert("amazed");
        t.insert("alibaba");
        t.insert("ali express");
        t.insert("ebay");
        t.insert("walmart");

        List<String> lists = t.autocomplete("ama");

        for(String str : lists)
            System.out.println(str);
    }
}

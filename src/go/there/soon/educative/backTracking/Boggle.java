package go.there.soon.educative.backTracking;

import go.there.soon.scratch.practice.autocomplete.Trie;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Boggle {

    public static void main(String [] args) {
        char [][] grid ={
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'}
        };

        HashSet<String> dictionary = new HashSet<>();
        String [] words = {"cat", "cater", "art", "toon", "moon", "not", "eat", "ton"};

        for(String word : words) {
            dictionary.add(word);
        }

        Boggle boggle = new Boggle(grid, dictionary);
        System.out.println(boggle.find_all_words().toString());
    }

    private char [][] grid;
    private HashSet<String> dictionary;

    public Boggle(char [][] grid, HashSet<String> dictionary) {
        this.grid = grid;
        this.dictionary = dictionary;
    }

    public HashSet<String> find_all_words() {
        Trie root = new Trie();

        for(String word : dictionary) {
            root.insert(word);
        }

        HashSet<String> result = new HashSet<>();

        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                boolean [][] visited = new boolean[row][col];
                LinkedHashMap<Point, String> map = new LinkedHashMap<>();
                Point p = new Point(i, j);
                map.put(p, String.valueOf(grid[i][j]));

                while(!map.isEmpty()) {
                    Iterator<Point> points = map.keySet().iterator();

                    while(points.hasNext()) {
                        Point point = points.next();
                        int x = point.x;
                        int y = point.y;
                        map.remove(point);
                        String word = map.get(point);

                        generateWord(grid, visited, map, result, x-1, y, word, root);
                        generateWord(grid, visited, map, result, x-1, y-1, word, root);
                        generateWord(grid, visited, map, result, x-1, y+1, word, root);
                        generateWord(grid, visited, map, result, x, y-1, word, root);
                        generateWord(grid, visited, map, result, x, y+1, word, root);
                        generateWord(grid, visited, map, result, x+1, y, word, root);
                        generateWord(grid, visited, map, result, x+1, y-1, word, root);
                        generateWord(grid, visited, map, result, x+1, y+1, word, root);
                    }


                }
            }
        }

        return result;
    }

    public void generateWord(char [][] grid,
                             boolean [][] visited,
                             LinkedHashMap<Point, String> map,
                             HashSet<String> ans,
                             int x,
                             int y,
                             String word,
                             Trie root) {
        if(isValid(visited, x, y)) {
            String newWord = word + grid[x][y];

            if(root.isCompleteWord(newWord)) {
                ans.add(newWord);
            } else {
                if(root.contains(newWord)) {
                    Point point = new Point(x, y);
                    map.put(point, newWord);
                }
            }

            visited[x][y] = true;
        }
    }


    public boolean isValid(boolean [][] visited, int row, int col) {
        return row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && !visited[row][col];
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



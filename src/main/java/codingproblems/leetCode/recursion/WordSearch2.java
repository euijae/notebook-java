package codingproblems.leetCode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author euijae_kim
 * @note {
 * 		@date 11/25/2018 09:00 PM
 * 		unfinished - failed case is large amount of words and it needs to be previewed
 * 		before moving into the double for loops. Plus, learned a backtracking!! have to know why
 * 		isVisited[row][col] = false;!!
 * }
 */
public class WordSearch2 {

	public static void main(String[] args) {
		String [] words = {
				"aba","baa","bab","aaab","aaa","aaaa","aaba"
//				"aaa"
//				"oath","pea","eat","rain"
		};
		
		char [][] board = {
				{'a','b'},{'a','a'}
//				{'a', 'a'}
//				{'o', 'a', 'a', 'n'},{'e', 't', 'a', 'e'},{'i', 'h', 'k', 'r'},{'i', 'f', 'l', 'v'}
		};
		
		Solution s = new Solution();
		List<String> strings = s.findWords(board, words);
		for(String string : strings) 
			System.out.println(string);
		
	}
}

class Solution {
	public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        findWords(board, words, ans);
        return ans;
    }
	
	public void findWords(char [][] board, String [] words, List<String> ans) {
		boolean [][] isVisited = new boolean[board.length][board[0].length];
		
		for(String word : words) {
			String str = "";
			for(int row = 0; row < board.length; row ++) {
				for(int col = 0; col < board[row].length; col++) {
					if(word.charAt(0) == board[row][col]) {
						dfs(ans, str, word, 0, row, col, board, isVisited);
					}
				}
			}
			isVisited = new boolean[board.length][board[0].length];
		}
	}
	
	public void dfs(List<String> ans, String str, String word, int at, int row, int col, 
			char [][] board, boolean [][] isVisited) {
		if(!ans.contains(word) && str.equals(word)) {
			ans.add(str);
		} else if(checkValid(word, at, row, col, board, isVisited)) {
			str += board[row][col];
			
			isVisited[row][col] = true;
			dfs(ans, str, word, at+1, row+1, col, board, isVisited);
			dfs(ans, str, word, at+1, row-1, col  , board, isVisited);
			dfs(ans, str, word, at+1, row  , col+1, board, isVisited);
			dfs(ans, str, word, at+1, row  , col-1, board, isVisited);
			isVisited[row][col] = false;
		}
	}
	
	public boolean checkValid(String word, int at, int row, int col, char [][] board, boolean [][] isVisited) {
		return (row >= 0 && row < board.length
				&& col >= 0 && col < board[row].length
				&& at < word.length()
				&& !isVisited[row][col]
				&& board[row][col] == word.charAt(at));
	}
}
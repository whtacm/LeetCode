/**
 * 
 */
package f079.word.search;


/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * <p>
 * For example,<br>
 * Given board =
 * <p>
 * [<br>
 * ['A','B','C','E'],<br>
 * ['S','F','C','S'],<br>
 * ['A','D','E','E']<br>
 * ]
 * <p>
 * word = "ABCCED", -> returns true,<br>
 * word = "SEE", -> returns true,<br>
 * word = "ABCB", -> returns false.
 * <p>
 * Hide Tags: Array /Backtracking
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public boolean exist(char[][] board, String word) {

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String w1 = "ABCCED";
		// String w2 = "SEE";
		// String w3 = "ABCB";

		System.err.println(new Solution().exist(board, w1));
		// System.err.println(new Solution().exist(board, w2));
		// System.err.println(new Solution().exist(board, w3));
	}

}

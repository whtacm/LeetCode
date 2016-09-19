/**
 * 
 */
package f079.word.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

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
 * [ ["ABCE"],<br>
 * ["SFCS"],<br>
 * ["ADEE"] ]
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
	public class Coordinate {
		public int x;
		public int y;

		public Coordinate(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			int c = Integer.valueOf(Integer.toString(x) + Integer.toString(y));
			// System.out.println(c);
			return c;
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Coordinate oth = (Coordinate) obj;
			return this.x == oth.x && this.y == oth.y;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + x + ", " + y + ")";
		}

		public Coordinate[] getNeignbor() {
			return new Coordinate[] { new Coordinate(x - 1, y),
					new Coordinate(x + 1, y), new Coordinate(x, y - 1),
					new Coordinate(x, y + 1) };
		}
	}

	/**
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		if (word == null || word.trim().equalsIgnoreCase("")) {
			return true;
		}
		if (board == null || board.length == 0) {
			return false;
		}

		Character key = board[0][0];
		LinkedList<Coordinate> coorList;
		HashMap<Character, LinkedList<Coordinate>> map = new HashMap<Character, LinkedList<Coordinate>>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				key = board[i][j];
				if (map.containsKey(key)) {
					map.get(key).add(new Coordinate(i, j));
				} else {
					coorList = new LinkedList<Coordinate>();
					coorList.add(new Coordinate(i, j));
					map.put(key, coorList);
				}
			}
		}

		System.err.println(map + "\r\n");

		Stack<LinkedList<Coordinate>> seqStack = new Stack<LinkedList<Coordinate>>();
		// Stack<Coordinate> neiStack = new Stack<Solution.Coordinate>();

		Set<Coordinate> set = new HashSet<Solution.Coordinate>();
		
		seqStack.add(map.get(word.charAt(0)));

		boolean flag = false;

		set.add(seqStack.get(0).get(0));
		find(seqStack, seqStack.get(0).pop(),set, map, word, board, flag);

		return flag;
	}

	private void find(Stack<LinkedList<Coordinate>> seqStack,
			Coordinate coordinate,
			Set<Coordinate> set, HashMap<Character, LinkedList<Coordinate>> map, String word,
			char[][] board, boolean flag) {
		// TODO Auto-generated method stub

		System.out.println(seqStack + " - " + coordinate + " - "
				+ word.charAt(seqStack.size()) + " - " + flag);

		{
			Coordinate[] coors = coordinate.getNeignbor();
			LinkedList<Coordinate> list = map.get(word.charAt(seqStack.size()));

			LinkedList<Coordinate> cand = new LinkedList<Solution.Coordinate>();
			for (int i = 0; i < coors.length; i++) {
				if (list.contains(coors[i])) {
					cand.add(coors[i]);
				}
			}

			if (cand.size() == 0) {
				if (seqStack.get(seqStack.size() - 1).isEmpty()) {
					seqStack.pop();
					if (seqStack.size() == 0) {
						return;
					}
				}

				System.err.println("cand-0: " + seqStack + " - " + coordinate
						+ " - " + word.charAt(seqStack.size()) + " - " + flag);

				coordinate = seqStack.get(seqStack.size() - 1).pop();
				find(seqStack, coordinate, set, map, word, board, flag);
			} else {
				seqStack.add(cand);
				if (seqStack.size() == word.length() && set.size() == word.length()) {
					flag = true;
					return;
				}

				System.err.println("cand>0: " + seqStack + " - " + coordinate
						+ " - " + word.charAt(seqStack.size()) + " - " + flag);

				find(seqStack, cand.pop(), set, map, word, board, flag);
			}
		}
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

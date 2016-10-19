/**
 * 
 */
package c064.minimum.path.sum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Array Dynamic Programming <br>
 * Hide Similar Problems (M) Unique Paths (H) Dungeon Game
 * <p>
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int row = grid.length;
		int col = grid[0].length;

		int[][] min = new int[row][col];
		min[0][0] = grid[0][0];

		for (int i = 1; i < row; i++) {
			min[i][0] = grid[i][0] + min[i - 1][0];
		}

		for (int i = 1; i < col; i++) {
			min[0][i] = grid[0][i] + min[0][i - 1];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				min[i][j] = Math.min(min[i - 1][j], min[i][j - 1]) + grid[i][j];
			}
		}

		return min[row - 1][col - 1];
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.err.println(sln.minPathSum(null));
		System.err.println(sln.minPathSum(new int[][] {}));
		System.err.println(sln.minPathSum(new int[][] { { 9 }, { 1 }, { 4 },
				{ 8 } }));
		System.err.println(sln.minPathSum(new int[][] { { 9, 1, 4, 8 } }));
		System.err.println(sln.minPathSum(new int[][] { { 1, 2, 2 },
				{ 3, 4, 1 }, { 1, 7, 3 }, { 1, 1, 1 } }));
	}
}

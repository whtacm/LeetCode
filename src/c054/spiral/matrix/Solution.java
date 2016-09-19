/**
 * 
 */
package c054.spiral.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * <p>
 * For example,
 * <p>
 * Given the following matrix:
 * 
 * <p>
 * [ <br>
 * [ 1, 2, 3 ], <br>
 * [ 4, 5, 6 ], <br>
 * [ 7, 8, 9 ] <br>
 * ]
 * <p>
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * <p>
 * tags: array
 * <p>
 * 
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new LinkedList<Integer>();

		if (matrix == null || matrix.length == 0) {
			return list;
		}

		int[][] visited = new int[matrix.length][matrix[0].length];

		list.add(matrix[0][0]);
		visited[0][0] = 1;
		if (matrix.length == 1) {
			if (matrix[0].length == 1) {
				return list;
			} else {
				for (int i = 1; i < matrix[0].length; i++) {
					list.add(matrix[0][i]);
				}
				return list;
			}
		} else {
			if (matrix[0].length == 1) {
				for (int i = 1; i < matrix.length; i++) {
					list.add(matrix[i][0]);
				}
				return list;
			} else {
				fillList(matrix, 0, 1, 'r', list, visited);
			}
		}

		return list;
	}

	public void fillList(int[][] matrix, int i, int j, char dirct,
			List<Integer> list, int[][] visited) {
		// TODO Auto-generated method stub
		if (list.size() == matrix.length * matrix[0].length) {
			return;
		}

		// System.out.println("(" + i + ", " + j + ") -->> " + matrix[i][j]);

		list.add(matrix[i][j]);
		visited[i][j] = 1;
		switch (dirct) {
		case 'r':
			if (j < matrix[i].length - 1) {
				if (visited[i][j + 1] == 0) {
					fillList(matrix, i, j + 1, 'r', list, visited);
				} else {
					fillList(matrix, i + 1, j, 'd', list, visited);
				}
			} else {
				fillList(matrix, i + 1, j, 'd', list, visited);
			}
			break;
		case 'd':
			if (i < matrix.length - 1) {
				if (visited[i + 1][j] == 0) {
					fillList(matrix, i + 1, j, 'd', list, visited);
				} else {
					fillList(matrix, i, j - 1, 'l', list, visited);
				}
			} else {
				fillList(matrix, i, j - 1, 'l', list, visited);
			}
			break;
		case 'l':
			if (j > 0) {
				if (visited[i][j - 1] == 0) {
					fillList(matrix, i, j - 1, 'l', list, visited);
				} else {
					fillList(matrix, i - 1, j, 'u', list, visited);
				}
			} else {
				fillList(matrix, i - 1, j, 'u', list, visited);
			}
			break;
		default:
			if (i > 0) {
				if (visited[i - 1][j] == 0) {
					fillList(matrix, i - 1, j, 'u', list, visited);
				} else {
					fillList(matrix, i, j + 1, 'r', list, visited);
				}
			} else {
				fillList(matrix, i, j + 1, 'r', list, visited);
			}
			break;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 7, 8, 9 } };
		int[][] matrixa = new int[][] {};
		int[][] matrixb = new int[][] { { 1, 2, 3 } };
		int[][] matrixc = new int[][] { { 1 }, { 4 }, { 7 }, { 9 } };

		System.out.println(new Solution().spiralOrder(matrix));
		System.out.println(new Solution().spiralOrder(matrixa));
		System.out.println(new Solution().spiralOrder(matrixb));
		System.out.println(new Solution().spiralOrder(matrixc));
	}
}

/**
 * 
 */
package c059.spiral.matrix.two;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * <p>
 * For example, <br>
 * Given n = 3,
 * 
 * <p>
 * You should return the following matrix: <br>
 * [ <br>
 * [ 1, 2, 3 ], <br>
 * [ 8, 9, 4 ], <br>
 * [ 7, 6, 5 ] <br>
 * ]
 * 
 * <p>
 * Tags : array
 * <p>
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public int[][] generateMatrix(int n) {
		if (n < 1) {
			return new int[][] {};
		}

		int[][] array = new int[n][n];
		array[0][0] = 1;
		if (n == 1) {
			return array;
		}

		char dirct = 'r';
		char update = 'r';
		int i = 0, j = 0;
		for (int num = 2; num <= n * n; num++) {
			update = getDir(array, i, j, dirct);
			switch (update) {
			case 'r':
				j++;
				break;
			case 'd':
				i++;
				break;
			case 'l':
				j--;
				break;
			default:
				i--;
				break;
			}
			dirct = update;
			array[i][j] = num;
		}
		return array;
	}

	/**
	 * 
	 * @param array
	 * @param i
	 * @param j
	 * @param dirct
	 * @return
	 */
	public char getDir(int[][] array, int i, int j, char dirct) {
		// TODO Auto-generated method stub
		if ('r' == dirct) {
			if (j < array[i].length - 1) {
				if (array[i][j + 1] == 0) {
					return 'r';
				} else {
					return 'd';
				}
			} else {
				return 'd';
			}
		} else if ('d' == dirct) {
			if (i < array[j].length - 1) {
				if (array[i + 1][j] == 0) {
					return 'd';
				} else {
					return 'l';
				}
			} else {
				return 'l';
			}

		} else if ('l' == dirct) {
			if (j > 0) {
				if (array[i][j - 1] == 0) {
					return 'l';
				} else {
					return 'u';
				}
			} else {
				return 'u';
			}
		} else {
			if (i > 0) {
				if (array[i - 1][j] == 0) {
					return 'u';
				} else {
					return 'r';
				}
			}
		}
		return dirct;
	}

	public static void main(String[] args) {
		int[][] array = new Solution().generateMatrix(0);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
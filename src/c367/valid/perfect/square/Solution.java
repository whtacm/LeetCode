/**
 * 
 */
package c367.valid.perfect.square;

/**
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1: <br>
 * Input: 16<br>
 * Returns: True<br>
 * Example 2:
 * <p>
 * 
 * Input: 14<br>
 * Returns: False
 * <p>
 * Credits:<br>
 * Special thanks to @elmirap for adding this problem and creating all test
 * cases. <br>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags : Binary Search Math<br>
 * Hide Similar Problems : (M) Sqrt(x) <br>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	static int step = 0;

	public boolean isPerfectSquare(int num) {
		step = 1;
		System.err.print(num + "  ");
		int start = 1;
		int half = (num + 1) / 2;
		int temp = start;

		while (start <= half) {
			if (0 == compare(start, num) || 0 == compare(half, num)) {
				return true;
			} else {
				temp = (half - 1) / 2 > start ? (half - 1) / 2 : start;

				if (0 == compare(temp, num)) {
					return true;
				} else if (-1 == compare(temp, num)) {
					start = temp;
					half--;
				} else {
					half = temp;
					start++;
				}
			}

			step++;
		}

		return false;
	}

	public int compare(double n, double num) {

		if (num > n * n) {
			return -1;
		} else if (num == n * n) {
			return 0;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		Solution sln = new Solution();

		System.err.println(sln.isPerfectSquare(1) + " " + step);
		System.err.println(sln.isPerfectSquare(3) + " " + step);
		System.err.println(sln.isPerfectSquare(9) + " " + step);
		System.err.println(sln.isPerfectSquare(14) + " " + step);
		System.err.println(sln.isPerfectSquare(16) + " " + step);
		System.err.println(sln.isPerfectSquare(225) + " " + step);
		System.err.println(sln.isPerfectSquare(808201) + " " + step);
		System.err.println(sln.isPerfectSquare(Integer.MAX_VALUE) + " " + step);
	}
}
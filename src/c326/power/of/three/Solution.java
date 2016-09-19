/**
 * 
 */
package c326.power.of.three;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Follow up: <br>
 * Could you do it without using any loop / recursion?
 * <p>
 * Credits: <br>
 * Special thanks to @dietpepsi for adding this problem and creating all test
 * cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Math <br>
 * Hide Similar Problems (E) Power of Two (E) Power of Four
 * <p>
 * 
 * @author WangHaitao
 * 
 */
public class Solution {
	public boolean isPowerOfThree(int n) {
		//System.err.println(Integer.toString(n, 3));
		return Integer.toString(n, 3).matches("10*");
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.isPowerOfThree(9));
	}
}

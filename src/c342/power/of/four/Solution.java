/**
 * 
 */
package c342.power.of.four;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a
 * power of 4.
 * <p>
 * Example:<br>
 * Given num = 16, return true. Given num = 5, return false.
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 * <p>
 * Credits:<br>
 * Special thanks to @yukuairoy for adding this problem and creating all test
 * cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Bit Manipulation <br>
 * Hide Similar Problems (E) Power of Two (E) Power of Three
 * 
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isPowerOfFour(int num) {
        return Integer.toString(num, 4).matches("10*");
    }
	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.isPowerOfFour(1));
		System.out.println(sln.isPowerOfFour(3));
		System.out.println(sln.isPowerOfFour(27));
	}
}

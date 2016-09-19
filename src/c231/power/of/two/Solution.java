/**
 * 
 */
package c231.power.of.two;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Credits: Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases.
 * <p>
 * Hide Tags : Math Bit Manipulation <br>
 * Hide Similar Problems : (E) Number of 1 Bits
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isPowerOfTwo(int n) {
		return (n > 0) && ((n & (n - 1))) == 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isPowerOfTwo(-1));
		System.out.println(new Solution().isPowerOfTwo(0));
		System.out.println(new Solution().isPowerOfTwo(1));
		System.out.println(new Solution().isPowerOfTwo(3));
		System.out.println(new Solution().isPowerOfTwo(32));
	}
}

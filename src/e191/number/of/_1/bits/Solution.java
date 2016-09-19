/**
 * 
 */
package e191.number.of._1.bits;


/**
 * Write a function that takes an unsigned integer and returns the number of ¡¯1'
 * bits it has (also known as the Hamming weight).
 * <p>
 * For example, the 32-bit integer ¡¯11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * <p>
 * Credits:<br>
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Bit Manipulation<br>
 * Hide Similar Problems (E) Reverse Bits (E) Power of Two (M) Counting Bits
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	// you need to treat n as an unsigned value
		public int hammingWeight(int n) {

			int count = 0;

			while (n > 0) {
				if ((n ^ (n - 1)) == 1) {
					count++;
				}
				n >>= 1;
			}

			return count;
		}

		public static void main(String[] args) {
			Solution sln = new  Solution();
			System.out.println(sln.hammingWeight(0));
			System.out.println(sln.hammingWeight(1));
			System.out.println(sln.hammingWeight(3));
			
			System.out.println(sln.hammingWeight(1023));
		}
}

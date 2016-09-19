/**
 * 
 */
package c371.sum.of.two.integers;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * <p>
 * Example:<br>
 * Given a = 1 and b = 2, return 3.
 * <p>
 * Credits:<br>
 * Special thanks to @fujiaozhu for adding this problem and creating all test
 * cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Bit Manipulation<br>
 * Hide Similar Problems (M) Add Two Numbers
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int getSum(int a, int b) {
		int sum=a;
		int carry = b;
		
		while (carry!=0) {
			int tmp = sum^carry;
			carry = (sum & carry)<<1;
			sum = tmp;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Solution sln = new Solution();
		//System.out.println(sln.getSum(1, 2));
		System.out.println(sln.getSum(5, 10));
		//System.out.println(sln.getSum(1, 2));
	}
}

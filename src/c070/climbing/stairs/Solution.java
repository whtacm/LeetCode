/**
 * 
 */
package c070.climbing.stairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Dynamic Programming
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int climbStairs(int n) {
		int a = 0;
		int b = 1;
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.climbStairs(44));
	}
}

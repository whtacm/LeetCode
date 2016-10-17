/**
 * 
 */
package c198.house.robber;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * <p>
 * Credits: <br>
 * Special thanks to @ifanchu for adding this problem and creating all test
 * cases. Also thanks to @ts for adding additional test cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Dynamic Programming <br>
 * Hide Similar Problems (M) Maximum Product Subarray (M) House Robber II (M)
 * Paint House (E) Paint Fence (M) House Robber III
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}

		return dp[nums.length - 1];
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.rob(new int[] {}));
		System.out.println(sln.rob(new int[] { 2 }));
		System.out.println(sln.rob(new int[] { 1, 2 }));
		System.out.println(sln.rob(new int[] { 1, 2, 3, 6 }));
		System.out.println(sln.rob(new int[] { 114, 117, 207, 117, 235, 82, 90,
				67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81,
				90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129,
				64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144,
				240 }));
	}
}

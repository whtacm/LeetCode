/**
 * 
 */
package c045.jump.game.two;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * <br>
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * <br>
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * <p>
 * For example: <br>
 * Given array A = [2,3,1,1,4]
 * 
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public int jump(int[] nums) {

		if (nums == null || nums.length <= 1) {
			return 0;
		}

		// System.out.println(Arrays.toString(nums));

		if (nums[0] >= nums.length - 1) {
			return 1;
		}

		int steps = 0;
		int dist = 0;
		for (int i = 0; i < nums.length;) {
			dist = nums[i];

			if (i + dist >= nums.length - 1) {
				return steps + 1;
			}

			int maxDiff = 0;
			int index = 0;

			// System.out.println(i + " " + nums[i]);

			for (int j = i + 1; j < nums.length && j <= i + dist; j++) {
				// System.out.println("    " + j + " " + nums[j]);

				if (nums[j] + j > maxDiff) {
					maxDiff = nums[j] + j;
					if (maxDiff >= nums.length + 1) {
						return steps + 2;
					}
					index = j;

				}
			}

			i = index;
			steps++;
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.jump(null));
		System.out.println(sln.jump(new int[] {}));
		System.out.println(sln.jump(new int[] { 1, 1 }));
		System.out.println(sln.jump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(sln.jump(new int[] { 2, 3, 1, 1, 4, 1 }));
	}
}

/**
 * 
 */
package c238.product.of.array.except.self;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * <p>
 * Solve it without division and in O(n).
 * <p>
 * For example, given [1,2,3,4], return [24,12,8,6].
 * <p>
 * Follow up: Could you solve it with constant space complexity? (Note: The
 * output array does not count as extra space for the purpose of space
 * complexity analysis.)
 * <p>
 * Tags : array
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		int first = -1;
		int second = -1;

		for (int i = 0; i < nums.length; i++) {
			if (0 == nums[i]) {
				if (-1 == first) {
					first = i;
				} else {
					second = i;
				}
			} else {
				product *= nums[i];
			}

		}

		if (-1 == second) {
			if (-1 == first) {
				for (int i = 0; i < nums.length; i++) {
					nums[i] = product / nums[i];
				}
			} else {
				for (int i = 0; i < nums.length; i++) {
					if (i == first) {
						nums[i] = product;
					} else {
						nums[i] = 0;
					}

				}
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				nums[i] = 0;
			}
		}

		return nums;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		new Solution().productExceptSelf(nums);

		System.err.println(Arrays.toString(nums));
	}
}

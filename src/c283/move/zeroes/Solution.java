/**
 * 
 */
package c283.move.zeroes;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * <p>
 * 
 * Note:<br>
 * 1. You must do this in-place without making a copy of the array.<br>
 * 2. Minimize the total number of operations.
 * <p>
 * 
 * Credits: Special thanks to @jianchao.li.fighter for adding this problem and
 * creating all test cases. <br>
 * Subscribe to see which companies asked this question
 * <p>
 * 
 * Hide Tags Array Two Pointers<br>
 * Hide Similar Problems (E) Remove Element
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}

		int p = 0;
		int q = 0;

		while (p < nums.length) {
			if (nums[p] == 0) {
				q = p + 1;
				while (q < nums.length) {
					if (nums[q] != 0) {
						break;
					} else {
						q++;
					}
				}
				if (q < nums.length && nums[q] != 0) {
					nums[p] = nums[q];
					nums[q] = 0;
				} else {
					break;
				}
			}
			//print(nums);
			p++;
		}

		// print(nums);

	}

	public void print(int[] nums) {
		System.out.println("------- start -------");
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		// int[] nums =
		sln.moveZeroes(new int[] { 1, 0, 1, 0, 3, 12, 0 });
	}
}

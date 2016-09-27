/**
 * 
 */
package c169.majority.element;

import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than |_n/2_| times.
 * <p>
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * <p>
 * Credits: <br>
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Array Divide and Conquer Bit Manipulation <br>
 * Hide Similar Problems (M) Majority Element II
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int findMajorityElement(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			} else {
				if (map.get(nums[i]) > nums.length/2) {
					return nums[i];
				}else{
					map.put(nums[i], map.get(nums[i])+1);
					if (map.get(nums[i]) > nums.length/2) {
						return nums[i];
					}
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		int[] nums = { 1, 2, 1, 1, 5, 4, 6, 1, 1, 3, 1, 8, 1, 1 };
		System.out.println(sln.findMajorityElement(nums));
	}
}

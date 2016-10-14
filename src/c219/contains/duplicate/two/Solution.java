/**
 * 
 */
package c219.contains.duplicate.two;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Array Hash Table <br>
 * Hide Similar Problems (E) Contains Duplicate (M) Contains Duplicate III
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean containsNearbyDuplicate(int[] nums, int k) {

		if (nums == null || k < 1 || nums.length < 2) {
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				int pre = map.get(nums[i]);
				if (i - pre<=k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}

		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[30000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}

		Solution sln = new Solution();
		boolean flag = sln.containsNearbyDuplicate(nums, 15000);
		System.out.println(flag);
	}


}

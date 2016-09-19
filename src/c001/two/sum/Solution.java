/**
 * 
 */
package c001.two.sum;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example: <br>
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,<br>
 * return [0, 1].
 * <p>
 * UPDATE (2016/2/13):<br>
 * The return format had been changed to zero-based indices. Please read the
 * above updated description carefully.
 * 
 * <p>
 * Subscribe to see which companies asked this question
 * 
 * <p>
 * Hide Tags Array Hash Table<br>
 * Hide Similar Problems (M) 3Sum (M) 4Sum (M) Two Sum II - Input array is
 * sorted (E) Two Sum III - Data structure design
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int key, index1 = 1, index2 = 1, index = 1;
		for (int i = 0; i < numbers.length; ++i) {
			key = target - numbers[i];
			map.put(numbers[i], i + 1);
			if (map.containsKey(key)) {
				index1 = map.remove(key);
				index2 = i + 1;
				break;
			}
		}

		if (index1 == index2) {
			for (int i = index1; i < numbers.length; ++i) {
				key = target - numbers[i];
				map.put(numbers[i], i + 1);
				if (map.containsKey(key)) {
					index2 = map.remove(key);
					index = i + 1;
					break;
				}
			}
		}

		if (index1 > index2) {
			index1 = index2;
			index2 = index;
		}

		return new int[] { index1, index2 };
	}
}

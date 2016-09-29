/**
 * 
 */
package c217.contains.duplicate;

import java.util.HashMap;

/**
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Array Hash Table <br>
 * Hide Similar Problems (E) Contains Duplicate II (M) Contains Duplicate III
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean containsDuplicate(int[] nums) {
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hashmap.containsKey(nums[i])) {
				return true;
			} else {
				hashmap.put(nums[i], i);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		
		
		int[] nums = new int[Integer.MAX_VALUE];
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			nums[i] = i	;
		}
		
		Solution sln = new Solution();
		System.out.println(sln.containsDuplicate(nums));
	}
}

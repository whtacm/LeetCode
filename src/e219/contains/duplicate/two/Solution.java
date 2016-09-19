/**
 * 
 */
package e219.contains.duplicate.two;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new LinkedList<Integer>());
			}
			map.get(nums[i]).add(i);
		}

		// Integer key;
		List<Integer> value;
		Map.Entry<Integer, List<Integer>> entry;
		Iterator<Map.Entry<Integer, List<Integer>>> iter = map.entrySet()
				.iterator();
		while (iter.hasNext()) {
			entry = iter.next();
			// key = entry.getKey();
			value = entry.getValue();
			Collections.sort(value);
			for (int i = 1; i < value.size(); i++) {
				if (value.get(i) - value.get(i - 1) <= k) {
					return true;
				}
			}
		}

		return false;
	}

}

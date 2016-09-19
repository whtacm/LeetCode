/**
 * 
 */
package c350.intersection.of.two.arrays.two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example: <br>
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * <p>
 * Note:<br>
 * Each element in the result should appear as many times as it shows in both
 * arrays.<br>
 * The result can be in any order.
 * <p>
 * Follow up:<br>
 * What if the given array is already sorted? How would you optimize your
 * algorithm?<br>
 * What if nums1's size is small compared to nums2's size? Which algorithm is
 * better?<br>
 * What if elements of nums2 are stored on disk, and the memory is limited such
 * that you cannot load all elements into the memory at once?
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Binary Search Hash Table Two Pointers Sort<br>
 * Hide Similar Problems (E) Intersection of Two Arrays
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0
				|| nums2.length == 0) {
			return new int[] {};
		}

		HashMap<Integer, Set<Integer>> map1 = new HashMap<Integer, Set<Integer>>();
		HashMap<Integer, Set<Integer>> map2 = new HashMap<Integer, Set<Integer>>();

		for (int i = 0; i < nums1.length; i++) {
			if (!map1.containsKey(nums1[i])) {
				map1.put(nums1[i], new HashSet<Integer>());
			}
			map1.get(nums1[i]).add(i);

		}

		for (int i = 0; i < nums2.length; i++) {
			if (!map2.containsKey(nums2[i])) {
				map2.put(nums2[i], new HashSet<Integer>());
			}
			map2.get(nums2[i]).add(i);
		}

		Integer key;
		Set<Integer> value;
		Map.Entry<Integer, Set<Integer>> entry;
		Iterator<Map.Entry<Integer, Set<Integer>>> iter = map1.entrySet()
				.iterator();
		List<Integer> list = new LinkedList<Integer>();
		while (iter.hasNext()) {
			entry = iter.next();
			key = entry.getKey();
			value = entry.getValue();

			if (map2.containsKey(key)) {
				for (int i = 0; i < (value.size() <= map2.get(key).size() ? value
						.size() : map2.get(key).size()); i++) {
					list.add(key);
				}
			}
		}

		int[] array = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}

		return array;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		sln.print(sln.intersect(null, new int[] { 2, 2, 3, 1 }));
		sln.print(sln.intersect(new int[] {}, new int[] { 2, 2, 3, 1 }));
		sln.print(sln.intersect(new int[] { 1, 2, 2, 1, 3, 4 }, new int[] { 2,
				2, 3, 1 }));
	}

	public void print(int[] array) {
		System.out.println("\r\n---------------- start ----------------");
		System.out.print("[ ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println("]");
	}
}

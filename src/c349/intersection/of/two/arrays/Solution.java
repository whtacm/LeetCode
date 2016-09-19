/**
 * 
 */
package c349.intersection.of.two.arrays;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:<br>
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * 
 * Note:<br>
 * Each element in the result must be unique.<br>
 * The result can be in any order.
 * 
 * <P>
 * Subscribe to see which companies asked this question
 * <p>
 * 
 * Hide Tags Binary Search Hash Table Two Pointers Sort<br>
 * Hide Similar Problems (E) Intersection of Two Arrays II
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0
				|| nums2.length == 0) {
			return new int[] {};
		}

		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums1.length; i++) {
			map1.put(nums1[i], i);
		}

		for (int i = 0; i < nums2.length; i++) {
			map2.put(nums2[i], i);
		}

		Integer key;
		Map.Entry<Integer, Integer> entry;
		Iterator<Map.Entry<Integer, Integer>> iter = map1.entrySet().iterator();
		List<Integer> list = new LinkedList<Integer>();
		while (iter.hasNext()) {
			entry = iter.next();
			key = entry.getKey();
			if (map2.containsKey(key)) {
				list.add(key);
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
		sln.print(sln.intersection(null, new int[] { 2, 2, 3, 1 }));
		sln.print(sln.intersection(new int[] {}, new int[] { 2, 2, 3, 1 }));
		sln.print(sln.intersection(new int[] { 1, 2, 2, 1, 3, 4 }, new int[] {
				2, 2, 3, 1 }));
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

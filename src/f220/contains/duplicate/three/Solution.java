/**
 * 
 */
package f220.contains.duplicate.three;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * <p>
 * Hide Tags Binary Search Tree <br>
 * Hide Similar Problems (E) Contains Duplicate (E) Contains Duplicate II
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public class IndexValuePair implements Comparable<IndexValuePair> {
		int index;
		int value;

		public IndexValuePair(int idx, int v) {
			// TODO Auto-generated constructor stub
			index = idx;
			value = v;
		}

		@Override
		public int compareTo(IndexValuePair o) {
			// TODO Auto-generated method stub
			if (value < o.value) {
				return -1;
			}
			if (value > o.value) {
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + index + "," + value + ")";
		}
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		t = t > 0 ? t : -t;

		System.err.println("index dis:" + k + "  value dis:" + t);

		List<IndexValuePair> list = new LinkedList<Solution.IndexValuePair>();

		for (int i = 0; i < nums.length; i++) {
			list.add(new IndexValuePair(i, nums[i]));
		}

		Collections.sort(list);

		System.out.println(Arrays.asList(list));

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				
				if (list.get(j).value == Math.pow(2, 31)-1 && list.get(i).value<0) {
					break;
				}

				if (Math.abs(list.get(j).value - list.get(i).value) <= t) {
					if (Math.abs(list.get(j).index - list.get(i).index) <= k) {
						System.out.println(list.get(i) + ", " + list.get(j));
						return true;
					}
				} else {
					break;
				}
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 24, 45, 12, 3, 7, 10, 0 };

		Solution sln = new Solution();
		// System.out.println(sln.containsNearbyAlmostDuplicate(nums, 3, 1));

		System.out.println(sln.containsNearbyAlmostDuplicate(new int[] { -1,
				2147483647 }, 1, 2147483647));
	}
}

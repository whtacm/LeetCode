/**
 * 
 */
package c239.sliding.window.maximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * <p>
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * <p>
 * Window position --- Max <br>
 * --------------- ----- <br>
 * [1 3 -1] -3 5 3 6 7 -- 3 <br>
 * 1 [3 -1 -3] 5 3 6 7 -- 3 <br>
 * 1 3 [-1 -3 5] 3 6 7 -- 5 <br>
 * 1 3 -1 [-3 5 3] 6 7 -- 5 <br>
 * 1 3 -1 -3 [5 3 6] 7 -- 6 <br>
 * 1 3 -1 -3 5 [3 6 7] -- 7 <br>
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * <p>
 * 
 * Note: You may assume k is always valid, ie: 1 ¡Ü k ¡Ü input array's size for
 * non-empty array.
 * <p>
 * Follow up: Could you solve it in linear time?
 * <p>
 * 
 * Hint:<br>
 * 
 * How about using a data structure such as deque (double-ended queue)?
 * <p>
 * Tags: heap
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length <= 0 || k <= 0) {
			return new int[] {};
		}

		int[] array = new int[nums.length - k + 1];

		Deque<Integer> deque = new LinkedList<Integer>();

		for (int i = 0; i < k; i++) {
			while (deque.size() > 0 && nums[i] >= nums[deque.getLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}

		for (int i = k; i < nums.length; i++) {
			array[i - k] = nums[deque.getFirst()];
			while (deque.size() > 0 && nums[i] >= nums[deque.getLast()]) {
				deque.removeLast();
			}
			while (deque.size() > 0 && deque.getFirst() <= i - k) {
				deque.removeFirst();
			}
			deque.addLast(i);
		}

		array[nums.length - k] = nums[deque.getFirst()];

		return array;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.err.println(Arrays.toString(new Solution().maxSlidingWindow(
				nums, k)));

		nums = new int[] { 7, 2, 4 };
		k = 2;
		System.err.println(Arrays.toString(new Solution().maxSlidingWindow(
				nums, k)));
	}
}

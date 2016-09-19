/**
 * 
 */
package c035.search.insert.position;

/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Here are few examples. [1,3,5,6], 5 ¡ú 2 [1,3,5,6], 2 ¡ú 1 [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * <p>
 * Hide Tags : Array Binary Search
 * 
 * <p>
 * Hide Similar Problems : (M) Search for a Range
 * 
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int searchInsert(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

		while ((low <= high) && (low <= nums.length - 1)
				&& (high <= nums.length - 1)) {
			int middle = low + ((high - low) >> 1);
			if (target == nums[middle]) {
				return middle;
			} else if (target < nums[middle]) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		// System.err.println(low + ", " + high);

		if ((low == nums.length && high == low - 1) || (low == 0 && high == -1)
				|| (low > high)) {
			return low;
		}
		return -1;

	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] { 1, 3, 5, 6 };
		int target = 5;
		System.err.println(s.searchInsert(nums, target));

		nums = new int[] { 1, 3, 5, 6 };
		target = 2;
		System.err.println(s.searchInsert(nums, target));

		nums = new int[] { 1, 3, 5, 6 };
		target = 7;
		System.err.println(s.searchInsert(nums, target));

		nums = new int[] { 1, 3, 5, 6 };
		target = 0;
		System.err.println(s.searchInsert(nums, target));
	}
}

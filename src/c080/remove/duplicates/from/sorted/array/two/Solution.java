/**
 * 
 */
package c080.remove.duplicates.from.sorted.array.two;

import java.util.Arrays;

/**
 * Follow up for "Remove Duplicates":<br>
 * What if duplicates are allowed at most twice?
 * 
 * <p>
 * For example,<br>
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * <p>
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * <p>
 * Hide Tags: Array /Two Pointers
 * 
 * @author Jilvo
 *
 */
public class Solution {

	public int removeDuplicates(int[] nums) {

		if (nums.length < 3) {
			return nums.length;
		}

		int length = nums.length;
		int p = 0;
		int q = 0;

		int[] dup = new int[length];

		int i = 0;
		while (p < nums.length && q < nums.length) {
			if (nums[p] == nums[q]) {
				q++;
				if (q - p <= 2) {
					dup[i++] = nums[p];
				}
			} else {
				if (q - p > 2) {
					length -= q - p - 2;
				}
				p = q;
				dup[i++] = nums[q++];
			}
		}

		if (q - p > 2) {
			length -= q - p - 2;
		}

		for (int j = 0; j < length; j++) {
			nums[j] = dup[j];
		}
		
		return length;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 1, 1, 2, 2, 2, 3, 3, 4, 5 };
		Solution sln = new Solution();
		System.out.println(sln.removeDuplicates(A));

		System.out.println(sln.removeDuplicates(new int[] { 1, 1, 1, 2, 2 }));
	}

}

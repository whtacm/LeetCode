/**
 * 
 */
package c034.search.for_.range;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * 
 * <p>
 * For example, <br>
 * Given [5, 7, 7, 8, 8, 10] and target value 8,<br>
 * return [3, 4].
 * 
 * <p>
 * Subscribe to see which companies asked this question
 * 
 * <p>
 * Hide Tags Binary Search Array<br>
 * Hide Similar Problems (E) First Bad Version
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int[] searchRange(int[] A, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (A.length == 0 || (A.length > 0 && target < A[0])
				|| (A.length > 0 && target > A[A.length - 1])) {
			return new int[] { -1, -1 };
		}

		int start = 0;
		int end = A.length - 1;
		int[] array = get(A, target, start, end);
		if (target != A[array[0]]) {
			return new int[] { -1, -1 };
		} else {
			start = array[1];
			end = array[2];
		}
		return new int[] { start, end };
	}

	public int[] get(int[] A, int target, int start, int end) {
		int mid = start + (end - start) / 2;
		int[] mse;
		if (start <= end) {
			if (target == A[mid]) {
				start = get(A, target, start, mid - 1)[1];
				end = get(A, target, mid + 1, end)[2];
			} else if (target < A[mid]) {
				mse = get(A, target, start, mid - 1);
				mid = mse[0];
				start = mse[1];
				end = mse[2];
			} else {
				mse = get(A, target, mid + 1, end);
				mid = mse[0];
				start = mse[1];
				end = mse[2];
			}
		}
		return new int[] { mid, start, end };
	}
}

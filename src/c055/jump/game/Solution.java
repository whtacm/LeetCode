/**
 * 
 */
package c055.jump.game;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that
 * position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:<br>
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 * 
 * <p>
 * Tags: array,greedy
 * <p>
 * 
 * @author Jilvo
 * 
 *
 */
public class Solution {
	public boolean canJump(int[] A) {
		if (A.length == 0 || A.length == 1) {
			return true;
		}

		int maxStep = A[0];
		for (int i = 1; i < A.length; i++) {
			if (maxStep == 0)
				return false;
			maxStep--;
			if (maxStep < A[i]) {
				maxStep = A[i];
			}
			if (maxStep + i >= A.length - 1) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 1, 1, 4 };
		int[] arr2 = { 3, 2, 1, 0, 4 };

		Solution sln = new Solution();
		System.err.println(sln.canJump(arr1));
		System.err.println(sln.canJump(arr2));
	}
}

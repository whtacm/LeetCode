/**
 * 
 */
package c136.single.number;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * <p>
 * Note:<br>
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Hash Table Bit Manipulation<br>
 * Hide Similar Problems (M) Single Number II (M) Single Number III (M) Missing
 * Number (H) Find the Duplicate Number
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		for (int i = 1; i < A.length; ++i) {
			A[0] ^= A[i];
		}
		return A[0];
	}
}

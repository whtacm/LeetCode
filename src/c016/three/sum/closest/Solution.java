/**
 * 
 */
package c016.three.sum.closest;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * 
 * 
 * Hide Tags Array Two Pointers<br>
 * Hide Similar Problems (M) 3Sum (M) 3Sum Smaller
 * <P>
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public int threeSumClosest(int[] num, int target) {
		if (num.length == 3) {
			return num[0] + num[1] + num[2];
		}

		int sum = 0;
		Arrays.sort(num);

		int p = 0;
		int q = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			p = i + 1;
			q = num.length - 1;
			while (p < q) {
				if (num[i] + num[p] + num[q] == target) {
					return target;
				} else {
					if (diff > Math.abs(num[i] + num[p] + num[q] - target)) {
						//
						diff = Math.abs(num[i] + num[p] + num[q] - target);
						sum = num[i] + num[p] + num[q];
					} else {
						if (p == i + 1 && num[i] == num[p]) {
							i++;
							break;
						}
					}

					if (num[i] + num[p] + num[q] > target) {
						q--;
					} else {
						p++;
					}
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] num = { -1, 2, 1, -4, -4, -5, 0 };
		int target = 1;
		int result = 0;

		Solution solution = new Solution();

		result = solution.threeSumClosest(num, target);

		System.out.println(result);
		
		System.out.println(solution.threeSumClosest(num, -4));
		System.out.println(solution.threeSumClosest(num, -6));
	}
}

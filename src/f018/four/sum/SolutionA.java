/**
 * 
 */
package f018.four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * <p>
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ¡Ü b ¡Ü c ¡Ü d) <br>
 * The solution set must not contain duplicate quadruplets.
 * 
 * <p>
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * <br>
 * A solution set is: <br>
 * (-1, 0, 0, 1) <br>
 * (-2, -1, 1, 2) <br>
 * (-2, 0, 0, 2)
 * 
 * <p>
 * 
 * Hide Tags: Array/ Hash Table/ Two Pointers
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class SolutionA {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (nums == null || nums.length < 4)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;
				int k = j + 1;
				int l = nums.length - 1;
				while (k < l) {
					if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
						k++;
					} else if (nums[i] + nums[j] + nums[k] + nums[l] > target) {
						l--;
					} else {
						List<Integer> t = new ArrayList<Integer>();
						t.add(nums[i]);
						t.add(nums[j]);
						t.add(nums[k]);
						t.add(nums[l]);
						result.add(t);

						k++;
						l--;

						while (k < l && nums[l] == nums[l + 1]) {
							l--;
						}

						while (k < l && nums[k] == nums[k - 1]) {
							k++;
						}
					}

				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };

		SolutionA sln = new SolutionA();
		System.err.println(sln.fourSum(num, 0));
	}
}

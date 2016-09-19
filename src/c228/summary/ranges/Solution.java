/**
 * 
 */
package c228.summary.ranges;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 * <p>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * <p>
 * 
 * Tags : Array
 * <p>
 * 
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new LinkedList<String>();

		if (nums.length == 0) {
			return list;
		}

		StringBuffer sb = new StringBuffer("");

		int start = 0, end = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1] + 1) {
				end = i;
			} else {
				if (start == end) {
					sb.append(nums[start]);
				} else {
					sb.append(nums[start] + "->" + nums[end]);
				}

				list.add(sb.toString());
				start = i;
				end = start;
				sb = new StringBuffer("");
			}
		}

		if (start == end) {
			sb.append(nums[start]);
		} else {
			sb.append(nums[start] + "->" + nums[end]);
		}
		list.add(sb.toString());

		return list;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.err.println(solution.summaryRanges(new int[] {}));
		System.err.println(solution.summaryRanges(new int[] { 0 }));
		System.err.println(solution.summaryRanges(new int[] { 0, 2, 4, 7 }));
		System.err.println(solution
				.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
	}
}

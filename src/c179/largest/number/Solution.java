/**
 * 
 */
package c179.largest.number;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * <p>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public class ExString implements Comparable<ExString> {

		private char[] array;

		public ExString(String str) {
			// TODO Auto-generated constructor stub
			array = str.toCharArray();
		}

		@Override
		public int compareTo(ExString other) {
			// TODO Auto-generated method stub

			return (new StringBuffer())
					.append(array)
					.append(other.array)
					.toString()
					.compareTo(
							(new StringBuffer()).append(other.array)
									.append(array).toString());
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return new String(array);
		}
	}

	public String largestNumber(int[] nums) {
		List<ExString> list = new LinkedList<ExString>();
		for (int i = 0; i < nums.length; i++) {
			list.add(new ExString(Integer.toString(nums[i])));
		}
		Collections.sort(list);

		// System.out.println(Arrays.asList(list));

		StringBuilder sb = new StringBuilder();

		for (int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i).toString());
		}

		if (sb.toString().matches("0*")) {
			return "0";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 32, 320, 34, 5, 9 };
		Solution sln = new Solution();
		System.err.println(sln.largestNumber(nums));

		System.out.println(sln.largestNumber(new int[] { 0, 0, 0, 0 }));

		System.out.println(sln.largestNumber(new int[] { 12, 121 }));
		System.out.println(sln.largestNumber(new int[]{824,8247}));
	}
}

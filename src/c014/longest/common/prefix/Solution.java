/**
 * 
 */
package c014.longest.common.prefix;

import java.util.HashMap;
import java.util.Map;


/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags String
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}

		int end = strs[0].length();

		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 0; i < strs.length; i++) {

			if (end == 0) {
				return "";
			}

			char[] array = strs[i].toCharArray();

			for (int j = 0; j < array.length && j < end; j++) {
				if (map.containsKey(j)) {
					Character ch = map.get(j);
					if (ch.equals(array[j])) {

					} else {
						end = j;
						break;
					}
				} else {
					map.put(j, array[j]);
				}
			}

			if (array.length < end) {
				end = array.length;
			}

			//System.out.println(end);
		}

		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Integer, Character> entry : map.entrySet()) {
			if (entry.getKey() < end) {
				sb.append(entry.getValue());
			} else {
				break;
			}

		}
		return sb.toString();
	}

	public static void main(String[] args) {

		Solution sln = new Solution();

		 System.out.println("-->>" + sln.longestCommonPrefix(null));
		
		 System.out.println("-->>"
		 + sln.longestCommonPrefix(new String[] { "abc" }));

		System.out
				.println("-->>"
						+ sln.longestCommonPrefix(new String[] { "abcd", "ab",
								"acd" }));
		System.out.println("-->>"
				+ sln.longestCommonPrefix(new String[] { "abcd", "abcefg",
						"abcdhiab" }));
	}
}

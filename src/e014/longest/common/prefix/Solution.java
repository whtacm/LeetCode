/**
 * 
 */
package e014.longest.common.prefix;

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
		if (strs == null) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}

		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			char[] array = strs[i].toCharArray();
			if (array.length == 0) {
				return "";
			}

		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println("--" + sln.longestCommonPrefix(null));

		System.out.println("--"
				+ sln.longestCommonPrefix(new String[] { "abc" }));

		System.out
				.println("--"
						+ sln.longestCommonPrefix(new String[] { "abcd", "ab",
								"acd" }));
		System.out.println("--"
				+ sln.longestCommonPrefix(new String[] { "abcd", "abcefg",
						"abcdhiab" }));
	}
}

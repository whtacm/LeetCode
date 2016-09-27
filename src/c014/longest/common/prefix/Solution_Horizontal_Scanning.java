/**
 * 
 */
package c014.longest.common.prefix;

/**
 * @author WangHaitao
 *
 */
public class Solution_Horizontal_Scanning {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		return prefix;
	}

	public static void main(String[] args) {

		Solution_Horizontal_Scanning sln = new Solution_Horizontal_Scanning();

		//System.out.println("-->>" + sln.longestCommonPrefix(null));

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

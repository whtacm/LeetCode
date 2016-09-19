/**
 * 
 */
package c058.length.of.last.word;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * <p>
 * For example, <br>
 * Given s = "Hello World", <br>
 * return 5.
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
	public int lengthOfLastWord(String s) {
		if (s.trim().equalsIgnoreCase("")) {
			return 0;
		}

		int last = 0;
		int length = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				length++;
			} else {
				if (length != 0) {
					last = length;
				}
				length = 0;

			}
		}
		return length == 0 ? last : length;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		// System.out.println(sln.lengthOfLastWord(""));
		// System.out.println(sln.lengthOfLastWord("Hello World"));
		// System.out.println(sln.lengthOfLastWord("HelloWorld"));
		// System.out.println(sln.lengthOfLastWord(" HelloWorld "));
		System.out.println(sln.lengthOfLastWord("Hello World  "));

		System.out.println(sln.lengthOfLastWord("b  a   "));
	}
}

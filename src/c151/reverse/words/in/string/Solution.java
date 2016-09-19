/**
 * 
 */
package c151.reverse.words.in.string;

/**
 * Given an input string, reverse the string word by word.
 * 
 * <p>
 * For example, <br>
 * Given s = "the sky is blue", <br>
 * return "blue is sky the".
 * 
 * 
 * <p>
 * Clarification: <br>
 * What constitutes a word? <br>
 * A sequence of non-space characters constitutes a word. <br>
 * Could the input string contain leading or trailing spaces? <br>
 * Yes. However, your reversed string should not contain leading or trailing
 * spaces. <br>
 * How about multiple spaces between two words? <br>
 * Reduce them to a single space in the reversed string.
 * 
 * <p>
 * tags : string
 * <p>
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0 || s.trim().length() == 0) {
			return "";
		}

		StringBuffer result = new StringBuffer("");
		String[] list = s.split(" ");

		// System.out.println(list.length);
		//
		// for (int i = 0; i < list.length; i++) {
		// System.out.println(list[i].length() + "-->>" + list[i]);
		// }

		for (int i = list.length - 1; i > 0; i--) {
			if (!list[i].equalsIgnoreCase(" ") && list[i].length() > 0) {
				result.append(list[i] + " ");
			}
		}
		if (!list[0].equalsIgnoreCase(" ") && list[0].length() > 0)
			result.append(list[0]);

		if (result.charAt(result.length() - 1) == ' ') {
			result.deleteCharAt(result.length() - 1);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String s = "  the sky is blue ";
		String r = new Solution().reverseWords(s);
		System.out.println(r);

	}
}

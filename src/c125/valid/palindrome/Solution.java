/**
 * 
 */
package c125.valid.palindrome;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * <p>
 * For example,<br>
 * "A man, a plan, a canal: Panama" is a palindrome.<br>
 * "race a car" is not a palindrome.<br>
 * <p>
 * Note:<br>
 * Have you consider that the string might be empty? This is a good question to
 * ask during an interview.
 * <p>
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Two Pointers String<br>
 * Hide Similar Problems (E) Palindrome Linked List
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution{
	public boolean isPalindrome(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s.length() == 0)
			return true;

		int i = 0, j = s.length() - 1;
		while (j >= i) {
			if (isAlphanumeric(s.charAt(i)) && isAlphanumeric(s.charAt(j))) {
				if (s.substring(i, i + 1).equalsIgnoreCase(
						s.substring(j, j + 1))) {

					++i;
					--j;
				} else {
					return false;
				}
			} else if (!isAlphanumeric(s.charAt(i))
					&& isAlphanumeric(s.charAt(j))) {
				++i;
			} else if (isAlphanumeric(s.charAt(i))
					&& !isAlphanumeric(s.charAt(j))) {
				--j;
			} else {
				++i;
				--j;
			}
		}
		return true;
	}

	public static boolean isAlphanumeric(char ch) {
		if ((0 <= ch - 'a' && ch - 'a' <= 26)
				|| (0 <= ch - 'A' && ch - 'A' <= 26)
				|| (0 <= ch - '0' && ch - '0' <= 9)) {
			return true;
		} else {
			return false;
		}
	}
}


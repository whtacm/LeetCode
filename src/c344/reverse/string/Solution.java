/**
 * 
 */
package c344.reverse.string;

/**
 * Write a function that takes a string as input and returns the string
 * reversed.
 * <p>
 * Example: <br>
 * Given s = "hello", return "olleh".
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Two Pointers String<br>
 * Hide Similar Problems (E) Reverse Vowels of a String
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public String reverseString(String s) {
		if (s==null) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(s.length()-1-i));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "hello";
		Solution sln = new Solution();
		System.out.println(sln.reverseString(s));
	}
}

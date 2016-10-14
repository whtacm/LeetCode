/**
 * 
 */
package c345.reverse.vowels.of.a.string;


/**
 * Write a function that takes a string as input and reverse only the vowels of
 * a string.
 * <p>
 * Example 1:<br>
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:<br>
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:<br>
 * The vowels does not include the letter "y".
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Two Pointers String <br>
 * Hide Similar Problems (E) Reverse String
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public String reverseVowels(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}

		byte[] array = s.getBytes();
		for (int i = 0, j = array.length - 1; i < j;) {
			if (isVowels(array[i]) && isVowels(array[j])) {
				byte temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
			if (!isVowels(array[i])) {
				i++;
			}
			if (!isVowels(array[j])) {
				j--;
			}
		}

		return new String(array);
	}

	public boolean isVowels(byte b) {
		if (b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u' ||
				b == 'A' || b == 'E' || b == 'I' || b == 'O' || b == 'U') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.reverseVowels("hello"));
		System.out.println(sln.reverseVowels("leetcode"));
	}
}

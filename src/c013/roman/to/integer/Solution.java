/**
 * 
 */
package c013.roman.to.integer;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * <p>
 * tags: math,string
 * <p>
 * 
 * @author Jilvo
 *
 *         has passed!!!!
 */
public class Solution {
	public int romanToInt(String s) {
		s = s.trim();
		int result = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'M':
				result += 1000;
				break;
			case 'D':
				result += 500;
				break;
			case 'C':
				if (i < s.length() - 1
						&& (s.charAt(i + 1) == 'M' || s.charAt(i + 1) == 'D')) {
					result -= 100;
				} else {
					result += 100;
				}
				break;
			case 'L':
				result += 50;
				break;
			case 'X':
				if (i < s.length() - 1
						&& (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
					result -= 10;
				} else {
					result += 10;
				}
				break;
			case 'V':
				result += 5;
				break;
			default:
				if (i < s.length() - 1
						&& (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
					result -= 1;
				} else {
					result += 1;
				}
				break;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		String s = "MCMXCVI";
		System.out.println(new Solution().romanToInt(s));
	}
}

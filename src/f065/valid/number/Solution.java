/**
 * 
 */
package f065.valid.number;

import java.util.regex.Pattern;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * Update (2015-02-10): The signature of the C++ function had been updated. If
 * you still see your function signature accepts a const char * argument, please
 * click the reload button to reset your code definition.
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isNumber(String s) {

		String s1 = "\\-?[0-9]{1,}";
		String s2 = "\\-?[0-9]{1,}.[0-9]{1,}";
		String s3 = "\\-?[0-9]{1,}e\\-?(0|[1-9][0-9]{0,})";
		String s4 = "\\-?[0-9]{1,}.[0-9]{1,}e\\-?(0|[1-9][0-9]{0,})";

		Pattern pattern1 = Pattern.compile(s1);
		Pattern pattern2 = Pattern.compile(s2);
		Pattern pattern3 = Pattern.compile(s3);
		Pattern pattern4 = Pattern.compile(s4);

		if (pattern1.matcher(s).matches() || pattern2.matcher(s).matches()
				|| pattern3.matcher(s).matches()
				|| pattern4.matcher(s).matches()) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isNumber("0"));
		System.out.println(solution.isNumber("abc"));
		System.out.println(solution.isNumber("-0.1"));
		System.out.println(solution.isNumber("1 a"));
		System.out.println(solution.isNumber("2e010"));
	}
}

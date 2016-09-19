/**
 * 
 */
package c017.letter.combinations.of.a.phone.number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * <p>
 * 
 * 
 * Input:Digit string "23" <br>
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * <p>
 * <a href=
 * "http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png"
 * >http://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2 .
 * svg/200px-Telephone-keypad2.svg.png </a>
 * 
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * 
 * Hide Tags Backtracking String<br>
 * Hide Similar Problems (M) Generate Parentheses (M) Combination Sum
 * <p>
 * 
 * @author Jilvo
 *
 */
public class Solution {

	public List<String> letterCombinations(String digits) {

		String[] dict = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		List<String> list = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();

		combinate(dict, 0, sb, digits, list);

		//System.out.println(list.size());
		return list;
	}

	private void combinate(String[] table, int index, StringBuilder sb,
			String digits, List<String> list) {
		// TODO Auto-generated method stub
		if (index == digits.length()) {
			if (sb.length() != 0) {
				list.add(sb.toString());
			}
		} else {
			String curStr = table[digits.charAt(index) - '0'];
			for (int i = 0; i < curStr.length(); i++) {
				sb.append(curStr.charAt(i));
				combinate(table, index + 1, sb, digits, list);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		String str = "239";
		System.err.println(sln.letterCombinations(str));
	}
}

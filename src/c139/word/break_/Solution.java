/**
 * 
 */
package c139.word.break_;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * For example, given<br>
 * s = "leetcode",<br>
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int[] flag = new int[s.length() + 1];
		flag[0] = 1;
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (flag[j] > 0 && dict.contains(s.substring(j, i))) {
					++flag[i];
					break;
				}
			}
		}

		return flag[s.length()] > 0;
	}
	
	public static void main(String[] args) {
		String s="leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("lee");
		dict.add("tcod");
		dict.add("code");
		Solution sln  = new Solution();
		System.out.println(sln.wordBreak(s, dict));
	}
}

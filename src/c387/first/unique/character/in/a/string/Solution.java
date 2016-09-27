/**
 * 
 */
package c387.first.unique.character.in.a.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode" return 0.
 * <p>
 * s = "loveleetcode", return 2.
 * <p>
 * Note: You may assume the string contain only lowercase letters.
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int firstUniqChar(String s) {
		HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();

		if (s == null || s.length() == 0) {
			return -1;
		}

		List<Integer> list;
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				list = new LinkedList<Integer>();
				list.add(i);
				map.put(s.charAt(i), list);
			} else {
				list = map.get(s.charAt(i));
				list.add(i);
			}
		}

		boolean has = false;
		int first = Integer.MAX_VALUE;
		for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 1 && entry.getValue().get(0) < first) {
				first = entry.getValue().get(0);
				has = true;
			}
		}

		return has ? first : -1;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.firstUniqChar("leetcode"));
		System.out.println(sln.firstUniqChar("loveleetcode"));
	}
}

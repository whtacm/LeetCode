/**
 * 
 */
package c242.valid.anagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * <p>
 * For example, <br>
 * s = "anagram", t = "nagaram", return true.<br>
 * s = "rat", t = "car", return false.
 * <p>
 * Note:<br>
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:<br>
 * What if the inputs contain unicode characters? How would you adapt your
 * solution to such case?
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Hash Table Sort<br>
 * Hide Similar Problems (M) Group Anagrams (E) Palindrome Permutation
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isAnagram(String s, String t) {
		if (s == null && t == null) {
			return true;
		}
		if ((s == null && t != null) || (s != null && t == null)) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Set<Integer>> sMap = new HashMap<Character, Set<Integer>>();
		HashMap<Character, Set<Integer>> tMap = new HashMap<Character, Set<Integer>>();

		for (int i = 0; i < s.length(); i++) {
			if (!sMap.containsKey(s.charAt(i))) {
				sMap.put(s.charAt(i), new HashSet<Integer>());
			}
			sMap.get(s.charAt(i)).add(i);

			if (!tMap.containsKey(t.charAt(i))) {
				tMap.put(t.charAt(i), new HashSet<Integer>());
			}
			tMap.get(t.charAt(i)).add(i);
		}

		Character key;
		Set<Integer> value;
		Map.Entry<Character, Set<Integer>> entry;
		Iterator<Map.Entry<Character, Set<Integer>>> iter = sMap.entrySet()
				.iterator();
		
		while (iter.hasNext()) {
			entry = iter.next();
			key = entry.getKey();
			value = entry.getValue();

			if (tMap.containsKey(key)) {
				if (value.size() != tMap.get(key).size()) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.isAnagram(null, "nagaram"));
		System.out.println(sln.isAnagram("anagram", null));
		System.out.println(sln.isAnagram("anagram", "nagar"));

		System.out.println(sln.isAnagram("anagram", "nagaram"));
		System.out.println(sln.isAnagram("rat", "car"));
	}
}

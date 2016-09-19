/**
 * 
 */
package f097.interleaving.string;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * <p>
 * When s3 = "aadbbbaccc", return false.
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		byte[] c1 = s1.getBytes();
		byte[] c2 = s2.getBytes();
		byte[] c3 = s3.getBytes();

		if (c1.length == 0) {
			for (int i = 0; i < c3.length; i++) {
				if (c2[i] != c3[i]) {
					return false;
				}
			}
			return true;
		}

		if (c2.length == 0) {
			for (int i = 0; i < c3.length; i++) {
				if (c1[i] != c3[i]) {
					return false;
				}
			}
			return true;
		}

		for (int i = 0, j = 0, k = 0; i < c1.length && j < c2.length;) {
			if (c3[k] != c1[i] && c3[k] != c2[j]) {
				return false;
			} else {
				if (c3[k] == c1[i]) {
					i++;
					k++;
					continue;
				} else {
					j++;
					k++;
					continue;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac", s4 = "aadbbbaccc";

		System.err.println(solution.isInterleave("", "", ""));
		System.err.println(solution.isInterleave("", s2, s3));
		System.err.println(solution.isInterleave("a", "", "c"));
		System.err.println(solution.isInterleave(s1, s2, ""));

		System.err.println(solution.isInterleave(s1, s2, s3));
		System.err.println(solution.isInterleave(s1, s2, s4));
		
		System.err.println(solution.isInterleave(s1, s2,"dababcbcac"));
	}
}

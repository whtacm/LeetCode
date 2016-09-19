/**
 * 
 */
package c258.add.digits;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * <p>
 * For example:<br>
 * 
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 * <p>
 * Follow up:<br>
 * Could you do it without any loop/recursion in O(1) runtime?
 * <p>
 * Hint:<br>
 * 1. A naive implementation of the above process is trivial. Could you come up
 * with other methods? <br>
 * 2. What are all the possible results?<br>
 * 3. How do they occur, periodically or randomly?<br>
 * 4. You may find this <a href
 * ="https://en.wikipedia.org/wiki/Digital_root">Wikipedia article</a> useful.
 * <p>
 * 
 * Credits:<br>
 * Special thanks to @jianchao.li.fighter for adding this problem and creating
 * all test cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Math<br>
 * Hide Similar Problems (E) Happy Number
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int addDigits(int num) {
		if (num < 10) {
			return num;
		}

		int remain = 0;

		while (num >= 10) {
			remain += num % 10;
			num /= 10;
			if (num < 10) {
				num += remain;
				remain = 0;
			}
		}

		return num;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.addDigits(189));
	}
}

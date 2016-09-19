/**
 * 
 */
package c202.happy.number;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example: 19 is a happy number<br>
 * <p>
 * 1^2 + 9^2 = 82 <br>
 * 8^2 + 2^2 = 68 <br>
 * 6^2 + 8^2 = 100 <br>
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isHappy(int n) {

		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

		int key = n;
		int value = -1;

		while (true) {
			if (hashmap.containsValue(1)) {
				return true;
			}

			value = getValueFromKey(key);
			if (hashmap.containsKey(value)) {
				return false;
			} else {
				hashmap.put(key, value);
				key = value;
			}

		}

	}

	private int getValueFromKey(int key) {
		// TODO Auto-generated method stub
		int sum = (int) Math.pow(key % 10, 2);
		int r = key / 10;
		while (r > 0) {
			sum += (int) Math.pow(r % 10, 2);
			r /= 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isHappy(9));
		System.out.println(solution.isHappy(19));
		System.out.println(solution.isHappy(0));
		System.out.println(solution.isHappy(1));
		System.out.println(solution.isHappy(2));
		System.out.println(solution.isHappy(12));
		System.out.println(solution.isHappy(13));
		System.out.println(solution.isHappy(37));
	}
}

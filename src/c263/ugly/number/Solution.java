/**
 * 
 */
package c263.ugly.number;

/**
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * <p>
 * 
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * 
 * Credits: <br>
 * Special thanks to @jianchao.li.fighter for adding this problem and creating
 * all test cases.
 * <p>
 * 
 * Subscribe to see which companies asked this question
 * <p>
 * 
 * Hide Tags Math <br>
 * Hide Similar Problems (E) Happy Number (E) Count Primes (M) Ugly Number II
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isUgly(int num) {
		System.out.print(num + "--");
		
		num = num >= 0 ? num : -num;
		if (num == 0) {
			return false;
		}

		if (num == 4) {
			return true;
		}

		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
				continue;
			}
			if (num % 3 == 0) {
				num /= 3;
				continue;
			}
			if (num % 5 == 0) {
				num /= 5;
				continue;
			}

			if (num != 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.isUgly(1));
		System.out.println(sln.isUgly(2));
		System.out.println(sln.isUgly(3));
		System.out.println(sln.isUgly(4));
		System.out.println(sln.isUgly(5));
		System.out.println(sln.isUgly(6));
		System.out.println(sln.isUgly(7));
		System.out.println(sln.isUgly(8));
		System.out.println(sln.isUgly(9));
		System.out.println(sln.isUgly(10));
		System.out.println(sln.isUgly(11));
		System.out.println(sln.isUgly(12));
		System.out.println(sln.isUgly(15));
	}
}

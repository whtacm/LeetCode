/**
 * 
 */
package s412.fizz.buzz;

import java.util.LinkedList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to
 * n. <br>
 * But for multiples of three it should output ¡°Fizz¡± instead of the number and
 * for the multiples of five output ¡°Buzz¡±. For numbers which are multiples of
 * both three and five output ¡°FizzBuzz¡±.
 * <p>
 * Example: <br>
 * n = 15, <br>
 * <code>
Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
<code>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public List<String> fizzBuzz(int n) {
		List<String> list = new LinkedList<String>();
		list.add("1");
		int fizz = 0;
		int buzz = 0;
		int fizz_buzz = 0;

		for (int i = 2; i <= n; i++) {
			if (15 == i - fizz_buzz) {
				list.add("FizzBuzz");
				fizz = i;
				buzz = i;
				fizz_buzz = i;
			} else if (5 == i - buzz) {
				list.add("Buzz");
				buzz = i;
			} else if (3 == i - fizz) {
				list.add("Fizz");
				fizz = i;
			} else {
				list.add("" + i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.fizzBuzz(30));
	}
}

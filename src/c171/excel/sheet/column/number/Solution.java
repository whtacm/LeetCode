/**
 * 
 */
package c171.excel.sheet.column.number;

/**
 * Related to question Excel Sheet Column Title
 * <p>
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * <p>
 * For example:<br>
 * 
 * A -> 1<br>
 * B -> 2<br>
 * C -> 3<br>
 * ...<br>
 * Z -> 26<br>
 * AA -> 27<br>
 * AB -> 28 <br>
 * <p>
 * Credits:<br>
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Math<br>
 * Hide Similar Problems (E) Excel Sheet Column Title
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int titleToNumber(String s) {
		if (s==null) {
			return 0;
		}
		char[] array = s.toCharArray();

		int sum = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			sum += (array[i] - 'A' + 1) * Math.pow(26, array.length - 1 - i);
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.titleToNumber("A"));
		System.out.println(sln.titleToNumber("Z"));
		System.out.println(sln.titleToNumber("AA"));
		System.out.println(sln.titleToNumber("AB"));
		System.out.println(sln.titleToNumber("AZ"));
		System.out.println(sln.titleToNumber("BA"));
		System.out.println(sln.titleToNumber("ABA"));
	}
}

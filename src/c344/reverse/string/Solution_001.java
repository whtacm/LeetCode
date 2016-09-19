/**
 * 
 */
package c344.reverse.string;

/**
 * @author WangHaitao
 *
 */
public class Solution_001 {
	public String reverseString(String s) {
		if (s==null) {
			return null;
		}
		if (s.equals("")) {
			return s;
		}
		
		char[] array = s.toCharArray();
		char tmp;
		for (int i = 0; i < array.length / 2; i++) {
			tmp = array[i];
			array[i]= array[array.length-1-i];
			array[array.length-1-i] = tmp;
		}
		
		
		return new String(array);
	}
	
	
	public static void main(String[] args) {
		String s = "hello";
		Solution_001 sln = new Solution_001();
		System.err.println(sln.reverseString(s));
	}
}

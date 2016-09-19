package c258.add.digits;

/**
 * 
 * @author WangHaitao
 *
 */
public class Solution_001 {
	public int addDigits(int num) {
		return (num - 1) % 9 + 1;
	}

	public static void main(String[] args) {
		Solution_001 sln = new Solution_001();
		System.out.println(sln.addDigits(123));
	}
}

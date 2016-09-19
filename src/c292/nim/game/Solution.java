/**
 * 
 */
package c292.nim.game;

/**
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean canWinNim(int n) {
		if (n <= 0)
			return false;
		return n % 4 != 0;
	}

	public static void main(String[] args) {
		Solution sln = new Solution();
		System.out.println(sln.canWinNim(4));
		System.out.println(sln.canWinNim(5));
	}
}

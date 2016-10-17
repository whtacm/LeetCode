/**
 * 
 */
package c042.rapping.rain.water;

/**
 * @author Jilvo
 *
 */
public class Solution {

	public int trap(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}

		int sum = 0;

		for (int i = 1; i < height.length - 1; i++) {
			sum += trap(height, i);
		}

		return sum;
	}

	private int trap(int[] a, int i) {
		// TODO Auto-generated method stub
		int leftMostHigh = 0;
		int rightMostHigh = 0;

		for (int j = 0; j < i; j++) {
			if (leftMostHigh < a[j]) {
				leftMostHigh = a[j];
			}
		}

		for (int j = i + 1; j < a.length; j++) {
			if (rightMostHigh < a[j]) {
				rightMostHigh = a[j];
			}
		}

		int max = Math.min(leftMostHigh, rightMostHigh);
		return max > a[i] ? max - a[i] : 0;
	}

	public static void main(String[] args) {
		int[] A = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Solution sln = new Solution();
		System.out.println(sln.trap(A));
		System.out.println(sln.trap(new int[] { 1, 2 }));
		System.out.println(sln.trap(new int[] { 1, 2, 1 }));

		System.out.println(sln.trap(new int[] { 1, 1, 1 }));
	}
}

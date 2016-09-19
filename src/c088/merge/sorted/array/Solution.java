/**
 * 
 */
package c088.merge.sorted.array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * <p>
 * Note: You may assume that A has enough space (size that is greater or equal
 * to m + n) to hold additional elements from B. The number of elements
 * initialized in A and B are m and n respectively.
 * <p>
 * 
 * 
 * Hide Tags Array Two Pointers<br>
 * Hide Similar Problems (E) Merge Two Sorted Lists
 * <p>
 * 
 * @author Jilvo
 *
 */
public class Solution {
	public final static int len = 7;
	public final static int m1 = 0;
	public final static int m2 = 3;
	public final static int n1 = 0;
	public final static int n2 = 4;

	public static int[] A1 = new int[len];
	public static int[] A2 = new int[] { 1, 4, 9, 0, 0, 0, 0 };

	public static int[] B1 = new int[n1];
	public static int[] B2 = new int[] { 0, 7, 18, 19 };

	public void merge(int A[], int m, int B[], int n) {
		if (m == 0) {
			if (n == 0) {
				return;
			} else {
				for (int i = 0; i < n; i++) {
					A[i] = B[i];
				}
				m = n;
			}
		} else {
			if (n == 0) {
				return;
			} else {
				int mpointer = 0;
				int npointer = 0;
				while (npointer < n) {
					// pay attention!!!!
					if (mpointer < m && A[mpointer] <= B[npointer]) {
						mpointer++;
					} else {
						if (mpointer < m) {
							for (int i = m; i > mpointer; i--) {
								A[i] = A[i - 1];
							}
							A[mpointer] = B[npointer];
							mpointer++;
							npointer++;
							m++;
						} else {
							for (int i = npointer; i < n; i++) {
								A[mpointer++] = B[npointer];
								npointer++;
								m++;
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new Solution().merge(A2, m2, B2, n2);
		System.out.println();
		System.out.println();
	}

}

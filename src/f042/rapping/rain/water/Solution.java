/**
 * 
 */
package f042.rapping.rain.water;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jilvo
 *
 */
public class Solution {

	public class IndexValuePair implements Comparable<IndexValuePair> {
		int index;
		int value;

		public IndexValuePair(int idx, int v) {
			// TODO Auto-generated constructor stub
			index = idx;
			value = v;
		}

		@Override
		public int compareTo(IndexValuePair o) {
			// TODO Auto-generated method stub
			if (value < o.value) {
				return -1;
			}
			if (value > o.value) {
				return 1;
			}
			return 0;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(" + index + "," + value + ")";
		}
	}

	public int trap(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}

		List<IndexValuePair> list = new LinkedList<Solution.IndexValuePair>();

		for (int i = 0; i < A.length; i++) {
			list.add(new IndexValuePair(i, A[i]));
		}

		Collections.sort(list);

		// System.out.println(Arrays.asList(list));

		if (list.get(0).value == list.get(list.size() - 1).value) {
			return 0;
		}

		int sum = 0;
		int p = 0;
		int q = 0;
		for (int i = 0; i < A.length - 2; i++) {
			if (list.get(i).index != 0 && list.get(i).index != list.size() - 1) {
				p = list.get(list.size() - 1).index;
				for (int j = A.length - 2; j > i; j--) {
					if ((p > list.get(i).index && list.get(j).index < list
							.get(i).index)
							|| (p < list.get(i).index && list.get(j).index > list
									.get(i).index)) {
						q = list.get(j).index;
						break;
					}
				}

				if (A[p] > list.get(i).value
						&& A[q] > list.get(i).value
						&& ((p > list.get(i).index && q < list.get(i).index) || (p < list
								.get(i).index && q > list.get(i).index))) {
					// System.out.println(i + "--" + list.get(i) + "  (" + p +
					// ","
					// + A[p] + "  (" + q + "," + A[q] + ")");
					sum += A[p] < A[q] ? A[p] - list.get(i).value : A[q]
							- list.get(i).value;
				}

			}
		}

		return sum;
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

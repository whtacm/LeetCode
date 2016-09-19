/**
 * 
 */
package f018.four.sum;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * 
 * <p>
 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 * (ie, a ¡Ü b ¡Ü c ¡Ü d) <br>
 * The solution set must not contain duplicate quadruplets.
 * 
 * <p>
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * <br>
 * A solution set is: <br>
 * (-1, 0, 0, 1) <br>
 * (-2, -1, 1, 2) <br>
 * (-2, 0, 0, 2)
 * 
 * <p>
 * 
 * Hide Tags: Array/ Hash Table/ Two Pointers
 * 
 * @author Jilvo
 * 
 */
public class Solution {
	/**
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		if (num.length < 4) {
			return list;
		} else {
			List<Integer> numList = new LinkedList<Integer>();
			for (int i = 0; i < num.length; i++) {
				numList.add(num[i]);
			}

			Collections.sort(numList);
			if (4 == num.length) {
				if (num[0] + num[1] + num[2] + num[3] == target) {
					list.add(numList);
					return list;
				}
			} else {

				int index = -1;
				int len = num.length;
				List<Integer> intList = null;
				int sum = target;
				// System.out.println(numList);
				for (int i = 0; i < len - 3; i++) {
					if (list.size() == 0
							|| (list.size() > 0 && numList.get(i) != list.get(
									index).get(0))) {
						sum -= numList.get(i);

						int p = 0;
						int q = 0;
						// int sum1 = 0;
						int diff = Integer.MAX_VALUE;
						for (int j = i + 1; j < len - 2; j++) {
							if (list.size() == 0 || list.size() > 0
									&& numList.get(j) != list.get(index).get(1)) {

								p = j + 1;
								q = len - 1;
								while (p < q) {

									System.out.println("["
											+ numList.get(i)
											+ ", "
											+ numList.get(j)
											+ ", "
											+ ", "
											+ numList.get(p)
											+ ", "
											+ ", "
											+ numList.get(q)
											+ "]  "
											+ (numList.get(i) + numList.get(j)
													+ numList.get(p) + numList
														.get(q)));

									if (numList.get(j) + numList.get(p)
											+ numList.get(q) == sum) {
										intList = new LinkedList<Integer>();
										intList.add(numList.get(i));
										intList.add(numList.get(j));
										intList.add(numList.get(p));
										intList.add(numList.get(q));

										list.add(intList);
									} else {
										if (diff > Math.abs(numList.get(j)
												+ numList.get(p)
												+ numList.get(q) - sum)) {
											//
											diff = Math.abs(numList.get(j)
													+ numList.get(p)
													+ numList.get(q) - sum);
											// sum1 = numList.get(j)
											// + numList.get(p)
											// + numList.get(q);
										} else {
											if (p == j + 1
													&& numList.get(j) == numList
															.get(p)) {
												j++;
												break;
											}
										}

										if (numList.get(j) + numList.get(p)
												+ numList.get(q) > sum) {
											q--;
										} else {
											p++;
										}
									}

									if (p + 1 == q) {
										break;
									}

								}
							}
							sum += numList.get(j);
						}
						sum = target;
					}
				}

			}
		}

		System.out.println(list);

		return list;
	}

	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };

		int target = 0;

		new Solution().fourSum(num, target);

	}
}

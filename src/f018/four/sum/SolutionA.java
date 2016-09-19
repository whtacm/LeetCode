/**
 * 
 */
package f018.four.sum;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
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
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class SolutionA {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();

		List<Integer> nList = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			nList.add(num[i]);
		}
		Collections.sort(nList);
		// System.err.println(nList);

		for (int i = 0; i < num.length; i++) {
			map.put(i, nList.get(i));
		}

		// System.err.println(map);
		// map.con

		find(list, target, map, 0, 1, 2);

		return list;
	}

	private void find(List<List<Integer>> list, int target,
			HashMap<Integer, Integer> map, int i, int j, int k) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		int[] num = { 1, 0, -1, 0, -2, 2 };

		SolutionA sln = new SolutionA();
		System.err.println(sln.fourSum(num, 0));
	}
}

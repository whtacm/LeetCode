/**
 * 
 */
package f134.gas.station;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * <p>
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * <p>
 * Note: <br>
 * The solution is guaranteed to be unique.
 * 
 * <p>
 * Hide Tags: Greedy
 * 
 * @author Jilvo
 *
 */
public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0) {
			return -1;
		}

		int sum = 0;
		int[] diff = new int[gas.length];
		for (int i = 0; i < diff.length; i++) {
			diff[i] = gas[i] - cost[i];
			sum += diff[i];
		}

		if (sum < 0) {
			return -1;
		}
		
	
		return -1;
	}

	public static void main(String[] args) {
		// int[] gas = {};
		// int[] cost = {};
		// int r = new Solution().canCompleteCircuit(gas, cost);

		// int[] gas = {1};
		// int[] cost = {2};
		// int r = new Solution().canCompleteCircuit(gas, cost);

		int[] gas = { 1, 3, 1 };
		int[] cost = { 2, 1, 1 };
		int r = new Solution().canCompleteCircuit(gas, cost);

		System.out.println(r);

	}
}

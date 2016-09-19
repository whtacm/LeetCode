/**
 * 
 */
package f134.gas.station;

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
		int index = -1;
		if (gas.length == 0) {
			return index;
		}
		if (gas.length == 1) {
			return 0;
		}

		// System.out.println("-->>");

		int next = -1;
		int cnext = -1;
		int maxStep = -1;
		boolean flag = false;
		for (int i = 0; i < gas.length; i++) {
			maxStep = gas[i];
			flag = true;
			for (int j = 1; j < gas.length; j++) {
				if (maxStep == 0) {
					flag = false;
					break;
				}
				next = j + i;
				cnext = j + i - 1;
				if (next >= gas.length) {
					next = Math.abs(next - gas.length);
				}
				if (cnext >= gas.length) {
					cnext = Math.abs(cnext - gas.length);
				}
				maxStep -= cost[cnext];
				if (maxStep >= 0) {
					maxStep += gas[next];
				} else {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}

		return index;
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

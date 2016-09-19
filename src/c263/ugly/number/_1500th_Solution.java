/**
 * 
 */
package c263.ugly.number;

/**
 * 
 * num = 2^a * 2^b * 5^c
 * 
 * 
 * @author WangHaitao
 *
 */
public class _1500th_Solution {
	public int get1500th() {

		double first = 2 * 3 * 5;
		int count = 0;
		// for (int i = 0; i < first; i++) {
		// if (isUgly(i)) {
		// count++;
		// System.out.println("num:" + i + " count:" + count);
		// }
		// }
		// count++;
		//
		// System.out.println("num:" + first + " count:" + count);

		int a = 0;
		int b = 0;
		int c = 0;

		double dn ;
		double tn ;
		double pn ;

		while (count < 1500) {
			dn = powered(a + 1, b, c);
			tn = powered(a, b + 1, c);
			pn = powered(a, b, c + 1);

			switch (whoIsMax(dn, tn, pn)) {
			case -1:
				a++;
				first = dn;
				break;
			case 0:
				b++;
				first = tn;
				break;
			default:
				c++;
				first = pn;
				break;
			}
			count++;

			System.out.println("num:" + first + " count:" + count);
		}

		return (int) first;
	}

	public int whoIsMax(double dn, double tn, double pn) {
		if (dn < tn && dn < pn) {
			return -1;
		}
		if (dn < tn && tn < pn) {
			return 0;
		}

		return 1;
	}

	public double powered(double a, double b, double c) {
		return Math.pow(2, a) * Math.pow(3, b) * Math.pow(5, c);
	}

	public boolean isUgly(int num) {
		// System.out.println(num + "--");

		num = num >= 0 ? num : -num;
		if (num == 0) {
			return false;
		}

		if (num == 4) {
			return true;
		}

		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
				continue;
			}
			if (num % 3 == 0) {
				num /= 3;
				continue;
			}
			if (num % 5 == 0) {
				num /= 5;
				continue;
			}

			if (num != 1) {
				return false;
			}
		}

		// System.out.println(num);

		return true;
	}

	public static void main(String[] args) {
		_1500th_Solution sln = new _1500th_Solution();
		System.err.println(sln.get1500th());
	}
}

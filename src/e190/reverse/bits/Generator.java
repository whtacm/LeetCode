/**
 * 
 */
package e190.reverse.bits;

/**
 * @author WangHaitao
 *
 */
public class Generator {
	public static void main(String[] args) {
		Integer[] array = new Integer[32];
		array[0] = 1;
		for (int i = 1; i < array.length; i++) {
			array[i] = array[i - 1] * 2;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ",");
		}
	}
}

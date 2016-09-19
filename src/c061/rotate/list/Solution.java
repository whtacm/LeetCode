/**
 * 
 */
package c061.rotate.list;

/**
 * Given a list, rotate the list to the right by k places, where k is
 * non-negative.
 * <p>
 * For example:<br>
 * Given 1->2->3->4->5->NULL and k = 2,<br>
 * return 4->5->1->2->3->NULL.
 * 
 * <p>
 * Subscribe to see which companies asked this question
 * 
 * <p>
 * Hide Tags Linked List Two Pointers<br>
 * Hide Similar Problems (E) Rotate Array
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public ListNode rotateRight(ListNode head, int n) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int len = length(head);
		if (len == 0 || n == 0) {
			return head;
		}
		int r = n % len;
		ListNode ptr = head, ptrNext;
		if (r == 0) {
			return head;
		} else {
			for (int i = 0; i < len - r - 1; ++i) {
				ptr = ptr.next;
			}
			ptrNext = ptr.next;
			ptr.next = null;
			ptr = ptrNext;
			while (ptr.next != null) {
				ptr = ptr.next;
			}
			ptr.next = head;
		}
		return ptrNext;
	}

	public int length(ListNode head) {
		int len = 0;
		if (head == null) {
			return 0;
		}
		ListNode ptr = head;
		while (ptr != null) {
			++len;
			ptr = ptr.next;
		}
		return len;
	}
}

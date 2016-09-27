/**
 * 
 */
package c141.linked.list.cycle;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * Follow up: <br>
 * Can you solve it without using extra space?
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Linked List Two Pointers <br>
 * Hide Similar Problems (M) Linked List Cycle II
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}

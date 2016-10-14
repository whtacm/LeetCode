/**
 * 
 */
package c024.swap.nodes.in.pairs;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example, <br>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Linked List <br>
 * Hide Similar Problems (H) Reverse Nodes in k-Group
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode h = new ListNode(-1);
		h.next = head;
		ListNode p = h;

		while (p.next != null && p.next.next != null) {
			ListNode t = p;
			p = p.next;
			t.next = p.next;

			t = p.next.next;
			p.next.next = p;
			p.next = t;
		}

		return h.next;
	}

	static void print(ListNode head) {
		while (head != null) {
			if (head.next != null) {
				System.out.print("" + head.val + "->");
			} else {
				System.out.print("" + head.val);
			}

			head = head.next;

		}
		System.out.println();
	}

	public static void main(String[] args) {
		Solution sln = new Solution();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		print(head);

		print(sln.swapPairs(head));
	}
}

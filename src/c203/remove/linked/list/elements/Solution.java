/**
 * 
 */
package c203.remove.linked.list.elements;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example <br>
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6<br>
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * <p>
 * Credits:<br>
 * Special thanks to @mithmatt for adding this problem and creating all test
 * cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Linked List<br>
 * Hide Similar Problems (E) Remove Element (E) Delete Node in a Linked List
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}

		ListNode p = head;
		ListNode q = head.next;

		while (p != null) {
			if (q != null) {
				if (q.val == val) {
					p.next = q.next;
					if (p != null) {
						q = p.next;
					}
				} else {
					p = p.next;
					q = p.next;
				}
			} else {
				break;
			}

		}

		// print(head);

		return head.val ==val?head.next:head;
	}

	public static void print(ListNode head) {
		System.out.println("-------- start ---------");

		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("nil");
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(1);

		Solution sln = new Solution();
		 print(sln.removeElements(head, 6));

		//print(sln.removeElements(head, 1));

		print(sln.removeElements(null, 4));
		print(sln.removeElements(new ListNode(1), 6));

		print(sln.removeElements(new ListNode(6), 6));

		head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);
		print(sln.removeElements(head, 1));
	}
}

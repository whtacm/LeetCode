/**
 * 
 */
package c234.palindrome.linked.list;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up: <br>
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Linked List Two Pointers <br>
 * Hide Similar Problems (E) Palindrome Number (E) Valid Palindrome (E) Reverse
 * Linked List
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// find list center
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondhalf = slow.next;
		slow.next = null;

		print(head);
		print(secondhalf);

		// reverse second part of the list
		ListNode p1 = secondhalf;
		ListNode p2 = p1.next;

		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondhalf.next = null;

		print(p1);
		print(p2);

		// compare two sublists now
		ListNode p = (p2 == null ? p1 : p2);
		ListNode q = head;
		while (p != null) {
			if (p.val != q.val)
				return false;

			p = p.next;
			q = q.next;

		}

		return true;
	}

	static void print(ListNode head) {
		if (head==null) {
			System.out.print("null");
		}
		
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
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next.next.next = new ListNode(9);
		print(head);

		sln.isPalindrome(head);
	}
}

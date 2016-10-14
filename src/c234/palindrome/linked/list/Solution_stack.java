/**
 * 
 */
package c234.palindrome.linked.list;

import java.util.Stack;

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
public class Solution_stack {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		Stack<Integer> stack = new Stack<Integer>();
		ListNode p = head;
		while (p != null) {
			stack.add(p.val);
			p = p.next;
		}
		
		
		p = head;
		while (p != null) {
			if (p.val!=stack.pop()) {
				return false;
			}
			p = p.next;
		}
		

		return true;
	}

	static void print(ListNode head) {
		if (head == null) {
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
		Solution_stack sln = new Solution_stack();

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

/**
 * 
 */
package c206.reverse.linked.list;

import java.util.List;

/**
 * Reverse a singly linked list.
 * <p>
 * click to show more hints.
 * <p>
 * Hint: A linked list can be reversed either iteratively or recursively. Could
 * you implement both?
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Linked List<br>
 * Hide Similar Problems (M) Reverse Linked List II (M) Binary Tree Upside Down
 * (E) Palindrome Linked List
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode p = head;
		while (p.next!=null) {
			find(p);
			print(head);
			p = p.next;
		}

		return head;
	}
	
	public void find(ListNode node){
		if (node.next == null) {
			return ;
		}
		
		find(node.next);
		int tmp = node.next.val;
		node.next.val = node.val;
		node.val = tmp;
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
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		print(head);
		System.out.println();
		
		
		Solution sln = new Solution();
		sln.reverseList(head);
		print(head);
	}
}

/**
 * 
 */
package c083.remove.duplicates.from.sorted.list;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * <p>
 * For example, <br>
 * Given 1->1->2, return 1->2.<br>
 * Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Linked List
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode p = head;
		ListNode q = p.next;

		while (p.next != null) {

			if (p.val == q.val) {
				q = q.next;
				if (q == null) {
					p.next = q;
					break;
				}
			} else {
				p.next = q;
				p = q;
				q = p.next;
			}
		}

		return head;
	}
	
	public static void print(ListNode head){
		System.out.println("---------- start ------------");
		while (head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("nil");
	}

	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(1);
		h1.next.next = new ListNode(2);

		ListNode h2 = new ListNode(1);
		h2.next = new ListNode(1);
		h2.next.next = new ListNode(2);
		h2.next.next.next = new ListNode(3);
		h2.next.next.next.next = new ListNode(3);
		
		Solution sln =new Solution();
		print(sln.deleteDuplicates(h1));
		
		print(sln.deleteDuplicates(h2));
	}
}

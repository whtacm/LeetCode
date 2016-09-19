/**
 * 
 */
package c021.merge.two.sorted.lists;


/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * <p>
 * 
 * Subscribe to see which companies asked this question
 * <p>
 * 
 * Hide Tags Linked List<br>
 * Hide Similar Problems (H) Merge k Sorted Lists (E) Merge Sorted Array (M)
 * Sort List (M) Shortest Word Distance II
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode l3 = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode r = l3;
		while (p != null && q != null) {
			if (p.val < q.val) {

				r.val = p.val;
				p = p.next;
			} else {
				r.val = q.val;
				q = q.next;
			}
			r.next = new ListNode(0);
			r = r.next;
		}

		if (p == null) {
			while (q != null) {
				r.val = q.val;
				q = q.next;
				if (q != null) {
					r.next = new ListNode(0);
					r = r.next;
				}

			}
		}

		if (q == null) {
			while (p != null) {
				r.val = p.val;
				p = p.next;
				if (p != null) {
					r.next = new ListNode(0);
					r = r.next;
				}
			}
		}

		return l3;
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
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(4);
		print(l1);

		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(1);
		l2.next.next = new ListNode(2);
		l2.next.next.next = new ListNode(5);
		print(l2);

		Solution sln = new Solution();
		print(sln.mergeTwoLists(l1, l2));
	}
}

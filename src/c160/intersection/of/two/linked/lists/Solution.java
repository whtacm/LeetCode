/**
 * 
 */
package c160.intersection.of.two.linked.lists;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * <p>
 * 
 * For example, the following two linked lists: <br>
 * A: a1 ¡ú a2<br>
 * ¨K<br>
 * c1 ¡ú c2 ¡ú c3<br>
 * ¨J <br>
 * B: b1 ¡ú b2 ¡ú b3<br>
 * begin to intersect at node c1.
 * 
 * <p>
 * Notes: <br>
 * If the two linked lists have no intersection at all, return null.<br>
 * The linked lists must retain their original structure after the function
 * returns.<br>
 * You may assume there are no cycles anywhere in the entire linked structure.<br>
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * <p>
 * Credits: <br>
 * Special thanks to @stellari for adding this problem and creating all test
 * cases.
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
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		int la = 0;
		int lb = 0;

		ListNode pa = headA;
		ListNode pb = headB;

		while (pa != null) {
			la++;
			pa = pa.next;
		}

		while (pb != null) {
			lb++;
			pb = pb.next;
		}

		int diff = 0;
		pa = headA;
		pb = headB;

		if (la > lb) {
			diff = la - lb;
			while (diff > 0) {
				pa = pa.next;
				diff--;
			}
		} else {
			diff = lb - la;
			while (diff > 0) {
				pb = pb.next;
				diff--;
			}
		}

		while (pa != null && pb != null) {
			if (pa.val == pb.val) {
				return pa;
			} else {
				pa = pa.next;
				pb = pb.next;
			}
		}

		return null;
	}
}

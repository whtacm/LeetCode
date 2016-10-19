/**
 * 
 */
package f173.binary.search.tree.iterator;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * <p>
 * Credits:<br>
 * Special thanks to @ts for adding this problem and creating all test cases.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Tree Stack Design<br>
 * Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Flatten 2D Vector
 * (M) Zigzag Iterator (M) Peeking Iterator (M) Inorder Successor in BST
 * 
 * @author Jilvo
 * 
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

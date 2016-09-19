/**
 * 
 */
package f173.binary.search.tree.iterator;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * 
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * <p>
 * Credits:<br>
 * Special thanks to @ts for adding this problem and creating all test cases.
 * 
 * <p>
 * Hide Tags: Tree/ Stack / design <br>
 * Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Flatten 2D Vector
 * (M) Zigzag Iterator (M) Peeking Iterator (M) Inorder Successor in BST
 * <p> 
 * 
 * @author Jilvo
 * 
 */
public class BSTIterator {
	TreeNode root = null;

	public BSTIterator(TreeNode root) {
		this.root = root;
	}

	/**
	 * 
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return false;
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {

		return -1;
	}
}

/**
 * 
 */
package c100.same.tree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <P>
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * <P>
 * Subscribe to see which companies asked this question
 * <P>
 * Hide Tags Tree Depth-first Search
 * <P>
 * 
 * @author WangHaitao
 *
 */
public class Solution {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p != null && q != null) {
			return p.val == q.val && isSameTree(p.left, q.left)
					&& isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}
}

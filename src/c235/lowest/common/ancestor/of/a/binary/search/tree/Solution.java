/**
 * 
 */
package c235.lowest.common.ancestor.of.a.binary.search.tree;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: ��The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).��
 * <p>
 * _______6______ / \ ___2__ ___8__ / \ / \ 0 4 7 9 / \ 3 5
 * <p>
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another
 * example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of
 * itself according to the LCA definition.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Tree<br>
 * Hide Similar Problems (M) Lowest Common Ancestor of a Binary Tree
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		}
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
}

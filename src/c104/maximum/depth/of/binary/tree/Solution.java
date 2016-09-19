/**
 * 
 */
package c104.maximum.depth.of.binary.tree;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root
 * node down to the farthest leaf node.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Tree Depth-first Search<br>
 * Hide Similar Problems (E) Balanced Binary Tree (E) Minimum Depth of Binary
 * Tree
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode rl = new TreeNode(11);
		TreeNode rr = new TreeNode(12);
		root.left = rl;
		root.right = rr;

		TreeNode rll = new TreeNode(111);
		TreeNode rlr = new TreeNode(112);
		rl.left = rll;
		rl.right = rlr;

		TreeNode rrl = new TreeNode(121);
		TreeNode rrr = new TreeNode(122);
		rr.left = rrl;
		rr.right = rrr;

		TreeNode rlll = new TreeNode(1211);
		TreeNode rllr = new TreeNode(1222);
		rll.left = rlll;
		rll.right = rllr;

		TreeNode rlrl = new TreeNode(1221);
		TreeNode rlrr = new TreeNode(1222);
		rlr.left = rlrl;
		rlr.right = rlrr;

		TreeNode rrll = new TreeNode(12211);
		rrl.left = rrll;

		Solution sln = new Solution();
		System.out.println(sln.maxDepth(root));
	}
}

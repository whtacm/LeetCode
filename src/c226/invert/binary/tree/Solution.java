/**
 * 
 */
package c226.invert.binary.tree;

/**
 * Invert a binary tree.
 * <p>
 * 4 / \ 2 7 / \ / \ 1 3 6 9 <br>
 * to <br>
 * 4 / \ 7 2 / \ / \ 9 6 3 1
 * <p>
 * Trivia: <br>
 * This problem was inspired by this original tweet by Max Howell:<br>
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you
 * can¡¯t invert a binary tree on a whiteboard so fuck off. Subscribe to see
 * which companies asked this question
 * <p>
 * Hide Tags Tree
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
		}else{
			return root;
		}

		if (root.left != null) {
			invertTree(root.left);
		}

		if (root.right != null) {
			invertTree(root.right);
		}

		return root;
	}

	public static void main(String[] args) {

	}
}

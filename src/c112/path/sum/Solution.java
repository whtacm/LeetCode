/**
 * 
 */
package c112.path.sum;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
<p>
For example:<br>
Given the below binary tree and sum = 22,<br>
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
<p>
Subscribe to see which companies asked this question
<p>
Hide Tags Tree Depth-first Search
Hide Similar Problems (M) Path Sum II (H) Binary Tree Maximum Path Sum (M) Sum Root to Leaf Numbers
<p>

 * @author WangHaitao
 *
 */
public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (root == null)
			return false;
		return preOrder(root, sum) > 0 ? true : false;
	}

	/**
	 * @param ptr
	 * @param r
	 * @return boolean
	 * 
	 */
	public int preOrder(TreeNode node, int r) {
		// TODO Auto-generated method stub
		int flag = 0;
		if (node != null) {
			if (node.left == null && node.right == null) {
				if (r - node.val == 0) {
					return 1;
				}
			}
			flag += preOrder(node.left, r - node.val);
			flag += preOrder(node.right, r - node.val);
		}
		return flag;
	}
}
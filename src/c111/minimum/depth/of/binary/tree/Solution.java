/**
 * 
 */
package c111.minimum.depth.of.binary.tree;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * <p>
 * Subscribe to see which companies asked this question
 * <p>
 * Hide Tags Tree Depth-first Search Breadth-first Search<br>
 * Hide Similar Problems (E) Binary Tree Level Order Traversal (E) Maximum Depth
 * of Binary Tree
 * <p>
 * 
 * @author WangHaitao
 *
 */
public class Solution {
    public int minDepth(TreeNode root) {
    	 // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null)
			return 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		preOrder(root, 1, list);
		Collections.sort(list);
		return list.removeFirst();
	}

	/**
	 * @param ptr
	 * @param r
	 * @return boolean
	 * 
	 */
	public void preOrder(TreeNode node, int depth, LinkedList<Integer> list) {
		// TODO Auto-generated method stub
		if (node != null) {
			if (node.left == null && node.right == null) {
				list.add(depth);
			}
			preOrder(node.left, ++depth, list);
			preOrder(node.right, depth, list);
		}
	}

}

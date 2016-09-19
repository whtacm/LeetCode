/**
 * 
 */
package c104.maximum.depth.of.binary.tree;

/**
 * @author WangHaitao
 *
 */
public class SolutionA {
	private int depth;

	public int maxDepth(TreeNode root) {
		depth = 0;
		find(root, 1);
		return depth;
	}

	private void find(TreeNode node, int curDepth) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		if (curDepth > depth) {
			depth = curDepth;
		}
		find(node.left, curDepth + 1);
		find(node.right, curDepth + 1);
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

		SolutionA sln = new SolutionA();
		System.out.println(sln.maxDepth(root));
	}
}

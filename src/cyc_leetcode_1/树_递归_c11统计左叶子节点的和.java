package cyc_leetcode_1;

public class 树_递归_c11统计左叶子节点的和 {

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (isLeaf(root.left)) {
			return root.left.val + sumOfLeftLeaves(root.right);
		}
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}
	
	private boolean isLeaf(TreeNode node) {
		if (node == null) {
			return false;
		}
		return node.left == null && node.right == null;
	}
}

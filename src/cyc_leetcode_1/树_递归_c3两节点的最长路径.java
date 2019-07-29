package cyc_leetcode_1;

public class 树_递归_c3两节点的最长路径 {

	private int max = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}
	
	private int maxDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}
}

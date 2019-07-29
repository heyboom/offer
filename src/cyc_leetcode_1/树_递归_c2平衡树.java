package cyc_leetcode_1;

public class 树_递归_c2平衡树 {

	private boolean result = true;
	
	public boolean isBalanced(TreeNode root) {
		depth(root);
		return result;
	}
	
	private int depth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		if (Math.abs(left - right) > 1) {
			result = false;
		}
		return Math.max(left, right) + 1;
	}
}

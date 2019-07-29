package cyc_leetcode_1;

public class 树_递归_c1树的高度 {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}

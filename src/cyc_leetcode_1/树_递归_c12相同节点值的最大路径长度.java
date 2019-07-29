package cyc_leetcode_1;

public class 树_递归_c12相同节点值的最大路径长度 {

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(longestPathWithRoot(root), Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right)));
	}
	
	private int longestPathWithRoot(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = 0, right = 0;
		if (root.left != null && root.val == root.left.val) {
			left = longestPathWithRoot(root.left) + 1;
		}
		if (root.right != null && root.val == root.right.val) {
			right = longestPathWithRoot(root.right) + 1;
		}
		return left + right;
	}
}

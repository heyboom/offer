package cyc_leetcode_1;

public class 树_递归_c12相同节点值的最大路径长度 {

	private int path = 0;
	
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return path;
	}
	
	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int lf = dfs(root.left);
		int rg = dfs(root.right);
		int lfPath = root.left != null && root.val == root.left.val ? lf + 1 : 0;
		int rgPath = root.right != null && root.val == root.right.val ? rg + 1 : 0;
		path = Math.max(path, lfPath + rgPath);
		return Math.max(lfPath, rgPath);
	}
}

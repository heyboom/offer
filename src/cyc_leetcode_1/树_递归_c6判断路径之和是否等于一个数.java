package cyc_leetcode_1;

public class 树_递归_c6判断路径之和是否等于一个数 {

	private boolean res = false;
	
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		dfs(root, sum, 0);
		return res;
	}
	
	private void dfs(TreeNode node, int sum, int result) {
		if (node == null) return;
		if (node.left == null && node.right == null) {
			result += node.val;
			if (result == sum)	res = true;
			return;
		}
		result += node.val;
		dfs(node.left, sum, result);
		dfs(node.right, sum, result);
		result -= node.val;
	}
	
	//cyc骚操作
	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null && root.val == sum) return true;
		return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
	}
}

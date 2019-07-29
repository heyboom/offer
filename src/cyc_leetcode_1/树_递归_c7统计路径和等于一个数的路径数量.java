package cyc_leetcode_1;

public class 树_递归_c7统计路径和等于一个数的路径数量 {

	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		return anyPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	public int anyPathSum(TreeNode node, int sum) {
		if (node == null) return 0;
		int res = 0;
		if (node.val == sum) res++;
		res += anyPathSum(node.left, sum - node.val) + anyPathSum(node.right, sum - node.val);
		return res;
	}
}

package jianzhioffer;

public class 二叉树的深度 {

	public int TreeDepth(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		return Math.max(left, right) + 1;
	}
}

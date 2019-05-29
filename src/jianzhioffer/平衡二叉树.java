package jianzhioffer;

public class 平衡二叉树 {

	public boolean IsBalanced_Solution(TreeNode root) {
		return getDepth(root) != -1;
	}
	
	public int getDepth(TreeNode root) {
		if(root == null)
			return 0;
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		if(left == -1 || right == -1)
			return -1;
		if(Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
}

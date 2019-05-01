package offer;

public class 平衡二叉树2 {

	private boolean isBalanced = true;
	
	public boolean IsBalanced_Solution(TreeNode root) {
		TreePath(root);
		return isBalanced;
	}
	
	public int TreePath(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = TreePath(root.left);
		int right = TreePath(root.right);
		int diff = left - right;
		if(diff < -1 || diff > 1) {
			isBalanced = false;
		}
		return 1 + Math.max(left, right);
	}
}

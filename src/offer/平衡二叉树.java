package offer;

public class 平衡二叉树 {

	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) {
			return true;
		}
		int deep = Math.abs(TreePath(root.left) - TreePath(root.right));
		if(deep <= 1) {
			return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
		}
		return false;
	}
	
	public int TreePath(TreeNode root) {
		int count = 0;
		if(root == null) {
			return count;
		}
		count = 1 + Math.max(TreePath(root.left), TreePath(root.right));
		return count;
	}
}

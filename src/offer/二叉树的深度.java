package offer;

public class 二叉树的深度 {

	public int TreeDepth(TreeNode root) {
		int count = 0;
		if(root == null) {
			return count;
		}
		count = 1 + Math.max(TreeDepth(root.left),TreeDepth(root.right));
		return count;
	}
}

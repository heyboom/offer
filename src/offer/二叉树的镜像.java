package offer;

public class 二叉树的镜像 {

	public void Mirror(TreeNode root) {
		if(root == null)
			return;
		TreeNode tmp = null;
		tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		Mirror(root.left);
		Mirror(root.right);
	}
}

package jianzhioffer;

public class 二叉树的镜像 {

	public void Mirror(TreeNode root) {
		if(root == null)
			return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		if(root.left != null)
			Mirror(root.left);
		if(root.right != null)
			Mirror(root.right);
	}
}

package cyc_leetcode_1;

public class 树_递归_c9树的对称 {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetricCore(root.left, root.right);
	}
	
	private boolean isSymmetricCore(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) return true;
		if (root1 == null || root2 == null) return false;
		if (root1.val != root2.val) return false;
		return isSymmetricCore(root1.left, root2.right)
				&& isSymmetricCore(root1.right, root2.left);
	}
}

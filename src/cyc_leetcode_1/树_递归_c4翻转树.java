package cyc_leetcode_1;

public class 树_递归_c4翻转树 {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		invertTree(root.left);
		invertTree(root.right);
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}
}

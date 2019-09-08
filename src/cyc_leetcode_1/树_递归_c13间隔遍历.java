package cyc_leetcode_1;

public class 树_递归_c13间隔遍历 {

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int valGap = root.val;
		if (root.left != null) {
			valGap += rob(root.left.left) + rob(root.left.right); 
		}
		if (root.right != null) {
			valGap += rob(root.right.left) + rob(root.right.right);
		}
		int val = rob(root.left) + rob(root.right);
		return Math.max(val, valGap);
	}
}

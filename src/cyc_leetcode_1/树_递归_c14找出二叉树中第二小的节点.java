package cyc_leetcode_1;

public class 树_递归_c14找出二叉树中第二小的节点 {

	public int findSecondMinimumValue(TreeNode root) {
		if (root == null) return -1;
		if (root.left == null && root.right == null) return -1;
		int leftVal = root.left.val;
		int rightVal = root.right.val;
		if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
		if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
		if (leftVal != -1 && rightVal != -1) {
			return Math.min(leftVal, rightVal);
		}
		if (leftVal != -1) return leftVal;
		return rightVal;
	}
	
}

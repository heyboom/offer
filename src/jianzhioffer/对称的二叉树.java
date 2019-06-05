package jianzhioffer;

public class 对称的二叉树 {

	public boolean isSymmetrical(TreeNode pRoot) {
		return isSymmetricalCore(pRoot, pRoot);
	}
	
	public boolean isSymmetricalCore(TreeNode node1, TreeNode node2) {
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
		if(node1.val != node2.val)
			return false;
		return isSymmetricalCore(node1.left, node2.right)
				&& isSymmetricalCore(node1.right, node2.left);
	}
}

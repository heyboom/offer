package offer;

public class 二叉搜索树的第K个节点 {

	private int index = 0;
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot == null || k < 1) {
			return null;
		}
		return KthNodeCore(pRoot, k);
	}
	
	TreeNode KthNodeCore(TreeNode pRoot, int k) {
		if(pRoot == null) {
			return null;
		}
		TreeNode leftTarget = KthNodeCore(pRoot.left, k);
		if(leftTarget != null) {
			return leftTarget;
		}
		index++;
		if(index == k) {
			return pRoot;
		}
		TreeNode rightTarget = KthNodeCore(pRoot.right, k);
		if(rightTarget != null) {
			return rightTarget;
		}
		return null;
	}
}

package jianzhioffer;

public class o54_二叉搜索树的第K小结点 {

	private int index = 0;
	
	public TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot == null || k <= 0) {
			return null;
		}
		return KthNodeCore(pRoot, k);
	}
	
	public TreeNode KthNodeCore(TreeNode node, int k) {
		if(node == null)
			return null;
		TreeNode target = KthNodeCore(node.left, k);
		if(target != null)
			return target;
		index++;
		if(index == k) {
			return node;
		}
		target = KthNodeCore(node.right, k);
		return target;
	}
}

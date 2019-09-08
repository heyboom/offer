package cyc_leetcode_1;

public class 树_BST_c3每个节点都加上比它大的节点值 {

	private int sum = 0;
	
	public TreeNode convertBST(TreeNode root) {
		traver(root);
		return root;
	}
	
	private void traver(TreeNode node) {
		if (node == null) return;
		traver(node.right);
		sum += node.val;
		node.val = sum;
		traver(node.left);
	}
}

package offer;

public class 二叉搜索树和双向链表 {

	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) {
			return null;
		}
		if(pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}
		TreeNode left = Convert(pRootOfTree.left);
		TreeNode p = left;
		while(p != null && p.right != null) p = p.right;
		if(left != null) {
			p.right = pRootOfTree;
			pRootOfTree.left = p;
		}
		TreeNode right = Convert(pRootOfTree.right);
		if(right != null) {
			pRootOfTree.right = right;
			right.left = pRootOfTree;
		}
		return left != null? left : pRootOfTree;
	}
}

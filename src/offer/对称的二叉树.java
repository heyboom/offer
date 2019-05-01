package offer;

public class 对称的二叉树 {

	boolean isSymmetrical(TreeNode pRoot) {
		if(pRoot == null) {
			return true;
		}
		return isSymmetrical(pRoot.left, pRoot.right);
	}
	
	boolean isSymmetrical(TreeNode tree1, TreeNode tree2) {
		if(tree1 == null && tree2 == null) {
			return true;
		}
		if(tree1 != null && tree2 != null && tree1.val == tree2.val) {
			return isSymmetrical(tree1.left, tree2.right)
					&& isSymmetrical(tree1.right, tree2.left);
		}
		return false;
	}
}

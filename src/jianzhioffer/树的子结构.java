package jianzhioffer;

public class 树的子结构 {

	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean flag = false;
		if(root1 != null && root2 != null) {
			if(root1.val == root2.val)
				flag = hasSubTreeCore(root1.left, root2.left) 
						&& hasSubTreeCore(root1.right, root2.right);
			if(!flag)
				flag = HasSubtree(root1.left, root2);
			if(!flag)
				flag = HasSubtree(root1.right, root2);
		}
		return flag;
	}
	
	public boolean hasSubTreeCore(TreeNode root1, TreeNode root2) {
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		if(root1.val != root2.val)
			return false;
		return hasSubTreeCore(root1.left, root2.left) 
				&& hasSubTreeCore(root1.right, root2.right);
	}
}

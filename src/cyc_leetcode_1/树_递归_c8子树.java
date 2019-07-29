package cyc_leetcode_1;
/*
 * 注意和剑指offer的“树的字结构”有区别，本例要求s,t一旦匹配，直到叶子节点都要一样
 */
public class 树_递归_c8子树 {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) return false;
		return isSubtreeCore(s, t) || isSubtree(s.left, t) || isSubtree(s.right , t);
	}
	
	public boolean isSubtreeCore(TreeNode s, TreeNode t) {
		if (t == null && s == null) return true;
		if (t == null || s == null) return false;
		if (t.val != s.val) return false;
		return isSubtreeCore(s.left, t.left) && isSubtreeCore(s.right, t.right);
	}
}

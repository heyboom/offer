package cyc_leetcode_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class 树_BST_c2查找二叉树的第K个元素 {
	
	private int ret;
	private int cnt;
	
	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return ret;
	}
	
	public void inorder(TreeNode root, int k) {
		if (root == null) return;
		inorder(root.left, k);
		cnt++;
		if (cnt == k) {
			ret = root.val;
			return;
		}
		inorder(root.right, k);
	}
	
	//不知道为什么错
	public int kthSmallest2(TreeNode root, int k) {
		if (root == null) return 0;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		int num = 0;
		while (num < k || cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			num++;
			if (num == k) {
				return num;
			}
			if (node.right != null) {
				cur = node.right;
			}
		}
		return 0;
	}
}

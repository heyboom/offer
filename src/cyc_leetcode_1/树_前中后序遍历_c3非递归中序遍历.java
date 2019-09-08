package cyc_leetcode_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 树_前中后序遍历_c3非递归中序遍历 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) return ret;
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			TreeNode node = stack.pop();
			ret.add(node.val);
			if (node.right != null) cur = node.right;
		}
		return ret;
	}
}

package cyc_leetcode_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 树_前中后序遍历_c1非递归前序遍历 {

	//ArrayDeque不允许null，而Stack可以
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		if (root == null) return ret;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			ret.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return ret;
	}
}

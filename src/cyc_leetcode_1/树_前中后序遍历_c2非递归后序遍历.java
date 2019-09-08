package cyc_leetcode_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class 树_前中后序遍历_c2非递归后序遍历 {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) return ret;
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			ret.add(node.val);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		Collections.reverse(ret);
		return ret;
	}
}

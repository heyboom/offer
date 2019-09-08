package cyc_leetcode_1;

import java.util.LinkedList;
import java.util.Queue;

public class 树_层次遍历_c2得到左下角的节点 {

	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode result = root;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == 0) {
					result = node;
				}
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
		}
		
		return result.val;
	}
}

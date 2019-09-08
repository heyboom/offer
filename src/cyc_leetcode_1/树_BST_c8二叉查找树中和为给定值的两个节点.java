package cyc_leetcode_1;

import java.util.ArrayList;
import java.util.List;

public class 树_BST_c8二叉查找树中和为给定值的两个节点 {

	public boolean findTarget(TreeNode root, int k) {
		List<Integer> nodes = new ArrayList<>();
		inOrder(root, nodes);
		for (int i = 0, j = nodes.size() - 1; i < j;) {
			int sum = nodes.get(i) + nodes.get(j);
			if (sum == k) {
				return true;
			} else if (sum < k) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
	
	private void inOrder(TreeNode root, List<Integer> nodes) {
		if (root == null) {
			return;
		}
		inOrder(root.left, nodes);
		nodes.add(root.val);
		inOrder(root.right, nodes);
	}
}

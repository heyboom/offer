package cyc_leetcode_1;

import java.util.ArrayList;
import java.util.List;

public class 树_c0_1根到某个节点的路径 {

	public List<TreeNode> findPath(TreeNode root, TreeNode target) {
		List<TreeNode> path = new ArrayList<>(); 
		List<TreeNode> copy = new ArrayList<>();
		findPath(root, target, path, copy);
		return copy;
	}

	public void findPath(TreeNode root, TreeNode target, List<TreeNode> path, List<TreeNode> copy) {
		if (root == null) return;
		if (root == target) {
			path.add(target);
			copy.addAll(path);
			return;
		}
		if (root.left == null && root.right == null) return;
		path.add(root);
		findPath(root.left, target, path, copy);
		findPath(root.right, target, path, copy);
		path.remove(path.size() - 1);
	}
}

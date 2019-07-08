package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c4_输出二叉树中所有从根到叶子的路径 {

	public static void main(String[] args) {
		搜索_回溯_c4_输出二叉树中所有从根到叶子的路径 demo = new 搜索_回溯_c4_输出二叉树中所有从根到叶子的路径();
		TreeNode root = new TreeNode(1);
		TreeNode l1 = new TreeNode(2);
		TreeNode l2 = new TreeNode(5);
		TreeNode r1 = new TreeNode(3);
		root.left = l1;
		root.right = r1;
		l1.right = l2;
		System.out.println(demo.binaryTreePaths(root));
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if(root == null)
			return paths;
		List<Integer> tmpPath = new ArrayList<>();
		doBiTreePath(root, paths, tmpPath);
		return paths;
	}
	
	private void doBiTreePath(TreeNode node, List<String> paths, List<Integer> tmpPath) {
		if(node == null)
			return;
		tmpPath.add(node.val);
		if (node.left == null && node.right == null) {
			paths.add(buildPath(tmpPath));
		} else {
			doBiTreePath(node.left, paths, tmpPath);
			doBiTreePath(node.right, paths, tmpPath);
		}
		tmpPath.remove(tmpPath.size() - 1);
	}
	
	private String buildPath(List<Integer> values) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < values.size(); i++) {
			str.append(values.get(i));
			if (i != values.size() - 1) {
				str.append("->");
			}
		}
		return str.toString();
	}
}

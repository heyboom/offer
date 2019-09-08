package cyc_leetcode_1;

import java.util.ArrayList;
import java.util.List;

public class 树_BST_c4二叉查找树的最近公共祖先 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode node2_1 = new TreeNode(2);
		TreeNode node2_2 = new TreeNode(8);
		TreeNode node3_1 = new TreeNode(0);
		TreeNode node3_2 = new TreeNode(4);
		TreeNode node3_3 = new TreeNode(7);
		TreeNode node3_4 = new TreeNode(9);
		TreeNode node4_1 = new TreeNode(3);
		TreeNode node4_2 = new TreeNode(5);
		root.left = node2_1;
		root.right = node2_2;
		node2_1.left = node3_1;
		node2_1.right = node3_2;
		node2_2.left = node3_3;
		node2_2.right = node3_4;
		node3_2.left = node4_1;
		node3_2.right = node4_2;
		
		System.out.println(lowestCommonAncestor(root, node2_1, node3_2).val);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> path1 = new ArrayList<>();
		List<TreeNode> path2 = new ArrayList<>();
		List<TreeNode> copy1 = new ArrayList<>();
		List<TreeNode> copy2 = new ArrayList<>();
		findPath(root, p, path1, copy1);
		findPath(root, q, path2, copy2);
		if (copy1 == null || copy2 == null) return null;
		//反序查找公共节点
		int minSize = Math.min(copy1.size(), copy2.size());
		for (int i = minSize - 1; i >= 0; i--) {
			if (copy1.get(i) == copy2.get(i)) {
				return copy1.get(i);
			}
		}
		return null;
	}
	
	//找出根到某个节点的路径
	private static void findPath(TreeNode root, TreeNode target, List<TreeNode> path, List<TreeNode> copy) {
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
	
	//cyc的递归版本
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val) return lowestCommonAncestor2(root.left, p, q);
		if (root.val < p.val && root.val < q.val) return lowestCommonAncestor2(root.right, p, q);
		return root;
	}
}

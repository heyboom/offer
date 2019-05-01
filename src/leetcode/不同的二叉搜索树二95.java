package leetcode;

import java.util.LinkedList;
import java.util.List;

public class 不同的二叉搜索树二95 {


	public List<TreeNode> generateTrees(int n) {
		if(n == 0)
			return new LinkedList<>();
		return generateSubTrees(1, n);
	}
	
	public List<TreeNode> generateSubTrees(int s, int e){
		List<TreeNode> res = new LinkedList<>();
		if(s > e) {
			res.add(null);
			return res;
		}
		for(int i = s; i <= e; i++) {
			List<TreeNode> leftSubTrees = generateSubTrees(s, i - 1);
			List<TreeNode> rightSubTrees = generateSubTrees(i + 1, e);
			
			for(TreeNode left : leftSubTrees) {
				for(TreeNode right : rightSubTrees) {
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}
		}
		return res;
	}
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}

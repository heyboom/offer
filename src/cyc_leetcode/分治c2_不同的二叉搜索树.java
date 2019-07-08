package cyc_leetcode;

import java.util.LinkedList;
import java.util.List;

public class 分治c2_不同的二叉搜索树 {

	public List<TreeNode> generateTrees(int n) {
		if(n < 1) {
			return new LinkedList<TreeNode>();
		}
		return generateSubtrees(1, n);
	}
	
	private List<TreeNode> generateSubtrees(int s, int e){
		List<TreeNode> res = new LinkedList<>();
		if (s > e) {
			res.add(null);
		}
		for(int i = s; i <= e; i++) {
			List<TreeNode> left = generateSubtrees(s, i - 1);
			List<TreeNode> right = generateSubtrees(i + 1, e);
			for(TreeNode l : left)
				for(TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
		}
		return res;
	}
}

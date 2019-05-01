package offer;

import java.util.*;

public class 把二叉树打印成多行 {

	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if(pRoot == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		int count = 1;
		TreeNode tmp = null;
		while(!queue.isEmpty()) {
			tmp = queue.poll();
			list.add(tmp.val);
			count--;
			if(tmp.left != null) {
				queue.offer(tmp.left);
			}
			if(tmp.right != null) {
				queue.offer(tmp.right);
			}
			if(count == 0) {
				result.add(list);
				list = new ArrayList<>();
				count = queue.size();
			}
		}
		return result;
	}
}

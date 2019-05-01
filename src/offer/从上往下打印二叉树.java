package offer;

import java.util.*;

public class 从上往下打印二叉树 {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			list.add(tmp.val);
			if(tmp.left != null) {
				queue.offer(tmp.left);
			}
			if(tmp.right != null) {
				queue.offer(tmp.right);
			}
		}
		return list;
	}
}

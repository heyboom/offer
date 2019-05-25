package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode tmp;
		while(!queue.isEmpty()) {
			tmp = queue.poll();
			list.add(tmp.val);
			if(tmp.left != null)
				queue.offer(tmp.left);
			if(tmp.right != null)
				queue.offer(tmp.right);
		}
		return list;
	}
}

package jianzhioffer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class o32_2把二叉树打印成多行 {

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if(pRoot == null)
			return lists;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		int count = 1;
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			count--;
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
			if(count == 0) {
				lists.add(list);
				count = queue.size();
				list = new ArrayList<>();
			}
		}
		return lists;
	}
}

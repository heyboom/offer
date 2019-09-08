package cyc_leetcode_1;

import java.util.LinkedList;
import java.util.Queue;

/*
 * {3,9,20,null,null,15,7}
 * 类似于层次遍历
 * 			3
 * 		---------	
 * 		|		|
 * 		9		20
 * 			---------
 * 			|		|
 * 			15		7
 */
public class 树_c0_2反序列化成二叉树 {

	public static void main(String[] args) {
		Integer[] nodes = {3,9,20,null,null,15,7};
		TreeNode root = deserialize(nodes);
		System.out.println(root);
	}
	
	public static TreeNode deserialize(Integer[] nodes) {
		if (nodes == null || nodes.length == 0) {
			return null;
		}
		Queue<Integer> queueIndex = new LinkedList<>();
		Queue<TreeNode> queueNode = new LinkedList<>();
		
		TreeNode root = new TreeNode(nodes[0]);
		queueIndex.offer(0);
		queueNode.offer(root);
		while (!queueIndex.isEmpty()) {
			TreeNode node = queueNode.poll();
			int index = queueIndex.poll();
			int left = index * 2 + 1;
			int right = left + 1;
			if (left < nodes.length && nodes[left] != null) {
				TreeNode lNode= new TreeNode(nodes[left]);
				node.left = lNode;
				queueNode.offer(lNode);
				queueIndex.offer(left);
			}
			if (right < nodes.length && nodes[right] != null) {
				TreeNode rNode = new TreeNode(nodes[right]);
				node.right = rNode;
				queueNode.offer(rNode);
				queueIndex.offer(right);
			}
		}
		return root;
	}
}

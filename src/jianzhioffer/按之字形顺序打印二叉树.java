package jianzhioffer;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class 按之字形顺序打印二叉树 {
	
	public static void main(String[] args) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		TreeNode n1 = new TreeNode(8);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(10);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(11);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		System.out.println(Print(n1));
	}
	public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		if(pRoot == null)
			return lists;
		Deque<TreeNode> stackOdd = new ArrayDeque<>();
		Deque<TreeNode> stackEven = new ArrayDeque<>();
		ArrayList<Integer> list;
		stackOdd.push(pRoot);
		while(!stackOdd.isEmpty() || !stackEven.isEmpty()) {
			list = new ArrayList<>();
			while(!stackOdd.isEmpty()) {
				TreeNode node = stackOdd.pop();
				list.add(node.val);
				if(node.left != null)
					stackEven.push(node.left);
				if(node.right != null)
					stackEven.push(node.right);
			}
			if(!list.isEmpty())
				lists.add(list);
			list = new ArrayList<>();
			while(!stackEven.isEmpty()) {
				TreeNode node = stackEven.pop();
				list.add(node.val);
				if(node.right != null)
					stackOdd.push(node.right);
				if(node.left != null)
					stackOdd.push(node.left);
			}
			if(!list.isEmpty())
				lists.add(list);
		}
		return lists;
	}
}


package offer;

import java.util.*;

public class 按之字形顺序打印二叉树 {
	
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if(pRoot == null) {
			return result;
		}
		Stack<TreeNode> leftStack = new Stack<>();
		Stack<TreeNode> rightStack = new Stack<>();
		leftStack.push(pRoot);
		TreeNode tmp = null;
		while(true) {
			while(!leftStack.isEmpty()) {
				tmp = leftStack.pop();
				list.add(tmp.val);
				if(tmp.left != null) {
					rightStack.push(tmp.left);
				}
				if(tmp.right != null) {
					rightStack.push(tmp.right);
				}
			}
			if(!list.isEmpty()) {
				result.add(list);
				list = new ArrayList<Integer>();
			}
			while(!rightStack.isEmpty()) {
				tmp = rightStack.pop();
				list.add(tmp.val);
				if(tmp.right != null) {
					leftStack.push(tmp.right);
				}
				if(tmp.left != null) {
					leftStack.push(tmp.left);
				}
			}
			if(!list.isEmpty()) {
				result.add(list);
				list = new ArrayList<Integer>();
			}
			if(leftStack.isEmpty() && rightStack.isEmpty()) {
				break;
			}
		}
		return result;
	}
}

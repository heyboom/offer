package structure;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class BianrySearchTree {

	private TreeNode root;
	private int size;
	
	public TreeNode add (Integer num) {
		if(num == null) {
			return root;
		}
		TreeNode node = new TreeNode(num);
		if(root == null) {
			root = node;
			return root;
		}
		TreeNode pre = root;
		TreeNode tmp = root;
		while(tmp != null) {
			pre = tmp;
			if(node.value < tmp.value) {
				tmp = tmp.left;
			}else {
				tmp = tmp.right;
			}
		}
		if(node.value < pre.value) {
			pre.left = node;
		}else {
			pre.right = node;
		}
		size++;
		return root;
	}

	public Boolean contains (Integer num) {
		if(num == null)
			return false;
		if(search(num) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	private TreeNode search (Integer num) {
		TreeNode tmp = root;
		while(tmp != null) {
			if(num == tmp.value) {
				return tmp;
			}else if(num < tmp.value) {
				tmp = tmp.left;
			}else {
				tmp = tmp.right;
			}
		}
		return tmp;
	}
	
	private TreeNode successor (TreeNode node) {
		TreeNode suc = null;
		if(node.right != null) {
			TreeNode tmp = node.right;
			TreeNode pre = node.right;
			while(tmp != null) {
				pre = tmp;
				if(tmp.left != null) {
					tmp = tmp.left;
				}
			}
			suc = pre;
		}
		return suc;
	}
	
	public TreeNode remove (Integer num) {
		if(num == null) {
			return root;
		}
		TreeNode node = null;
		TreeNode pre = null;
		TreeNode tmp = root;
		while(tmp != null) {
			if(tmp.value == num) {
				node = tmp;
				break;
			}else if(num < tmp.value) {
				pre = tmp;
				tmp = tmp.left;
			}else {
				pre = tmp;
				tmp = tmp.right;
			}
		}
		if(node == null) {
			return root;
		}
		TreeNode suc = null;
		if(node.left != null && node.right != null) {
			suc = successor(node);
			node.value = suc.value;
			remove(suc.value);
			size--;
			return root;
		}else {
			suc = node.left != null ? node.left : node.right;
		}
		if(node == pre.left) {
			pre.left = suc;
		}else {
			pre.right = suc;
		}
		size--;
		return root;
		
	}
	
	public void print() {
		ArrayList<Integer> list = new ArrayList<>();
		list = toList(root, list);
		System.out.println(list.toString());
		System.out.println();
	}
	
	public ArrayList toList(TreeNode root, ArrayList list){
		TreeNode node = null;
		if(root.left != null) {
			toList(root.left, list);
		}
		list.add(root.value);
		if(root.right != null) {
			toList(root.right, list);
		}
		return list;
	}
	
	
}


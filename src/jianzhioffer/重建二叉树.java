package jianzhioffer;

import java.util.Arrays;

public class 重建二叉树 {

	public static void main(String[] args) {
		int[] pre = {1,2,3,4,5,6,7};
		int[] in = {3,2,4,1,6,5,7};
		TreeNode node = reConstructBinaryTree(pre, in);
		print(node);
	}
	
	public static void print (TreeNode node) {
		if(node != null) {
			System.out.println(node.val);
			print(node.left);
			print(node.right);
		}
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre == null  || in == null || pre.length != in.length || pre.length == 0)
			return null;
		TreeNode root = new TreeNode(pre[0]);
		Integer rootIndex = find(in, pre[0]);
		if(rootIndex == null)
			return null;
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));
		return root;
	}
	
	public static Integer find(int[] num, int n) {
		if(num == null || num.length == 0)
			return null;
		for(int i = 0; i < num.length; i++) {
			if(num[i] == n)
				return i;
		}
		return null;
	}
	
}

package jianzhioffer;
import java.util.ArrayList;
/*
 * 带有备忘录的递归：
 * 注意引用变量和普通变量再递归调用链中的变化。
 */
public class 二叉树中和为某一值的路径 {
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<Integer> path = new ArrayList<>();
		ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
		if(root == null)
			return paths;
		int currentSum = 0;
		FindPath(root, target, path, paths, currentSum);
		return paths;
	}
	
	public static void FindPath(TreeNode node,int target, ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> paths, int currentSum) {
		currentSum += node.val;
		path.add(node.val);
		
		boolean isLeaf = node.left == null && node.right == null;
		if(currentSum == target && isLeaf) {
			ArrayList<Integer> pathCopy = new ArrayList<>();
			pathCopy.addAll(path);
			paths.add(pathCopy);
		}
		
		if(node.left != null)
			FindPath(node.left, target, path, paths, currentSum);
		if(node.right != null)
			FindPath(node.right, target, path, paths, currentSum);
		
		path.remove(path.size() - 1);
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(12);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		System.out.println(FindPath(node1, 22));
	}
}

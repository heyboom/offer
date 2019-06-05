package test;

public class Test {

	public static void main(String[] args) {
		System.out.println("123".compareTo("321"));
	}
	
	private int index = 0;
	
	TreeNode KthNode(TreeNode pRoot, int k) {
		if(pRoot == null || k < 1) {
			return null;
		}
		return KthNodeCore(pRoot, k);
	}
	
	TreeNode KthNodeCore(TreeNode node, int k) {
		if(node == null)
			return null;
		TreeNode target = KthNodeCore(node.left, k);
		if(target != null)
			return target;
		index++;
		if(index == k)
			return node;
		target = KthNodeCore(node.right, k);
		return target;
	}
}

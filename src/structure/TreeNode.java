package structure;

public class TreeNode {

	Integer value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode() {
		value = null;
		left = right = null;
	}
	
	public TreeNode(Integer value) {
		this.value = value;
		left = right = null;
	}
	
	public TreeNode(Integer value, TreeNode left, TreeNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

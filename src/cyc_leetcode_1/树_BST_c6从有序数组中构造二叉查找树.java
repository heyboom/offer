package cyc_leetcode_1;

public class 树_BST_c6从有序数组中构造二叉查找树 {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return toBST(nums, 0, nums.length - 1);
	}
	
	//注意mid 不能式(right - left) / 2
	//例如， -10，-3， 0， 5，9  在第二次迭代时，5和9的位置是3，4
	//如果(right-left)/2则定位到了（4-3）/2 = 0去了
	private TreeNode toBST(int[] nums, int left, int right) {
		if (right < left) return null;
		if (right == left) {
			return new TreeNode(nums[left]);
		}
		int mid = (right + left) / 2;	
		TreeNode root = new TreeNode(nums[mid]);
		root.left = toBST(nums, left, mid - 1);
		root.right = toBST(nums, mid + 1, right);
		return root;
	}
}

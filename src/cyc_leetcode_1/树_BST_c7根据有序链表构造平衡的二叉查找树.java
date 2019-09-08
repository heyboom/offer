package cyc_leetcode_1;

public class 树_BST_c7根据有序链表构造平衡的二叉查找树 {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		return toBST(head, null);
	}
	
	private TreeNode toBST(ListNode head, ListNode tail) {
		if (head == tail) return null;
		ListNode fast = head, slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow;
		TreeNode root = new TreeNode(mid.val);
		root.left = toBST(head, mid);
		root.right = toBST(mid.next, tail);
		return root;
	}
}

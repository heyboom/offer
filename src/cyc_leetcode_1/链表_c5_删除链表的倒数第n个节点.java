package cyc_leetcode_1;

public class 链表_c5_删除链表的倒数第n个节点 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = new ListNode(-1);
		node.next = head;
		ListNode fast = node;
		ListNode slow = node;
		while (n-- > 0){
			fast = fast.next;
		}
		while (fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return node.next;
	}
	
}

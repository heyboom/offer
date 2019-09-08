package cyc_leetcode_1;

public class 链表_c6_交换链表中的相邻结点 {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode node = swapPairs(head.next.next);
		ListNode newHead = head.next;
		head.next = node;
		newHead.next = head;
		return newHead;
	}
}

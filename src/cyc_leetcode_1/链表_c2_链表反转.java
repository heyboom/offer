package cyc_leetcode_1;

public class 链表_c2_链表反转 {

	// 迭代
	public ListNode reverseList(ListNode head) {
		ListNode pre = null, cur = head, next = null;
		ListNode newHead = null; 
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			if (cur == null){
				newHead = pre;
			}
		}
		return newHead;
	}
	
	// 递归
	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = reverseList(next);
		head.next = null;
		next.next = head;
		return newHead;
	}
	
	// 头插法
	public ListNode reverseList3(ListNode head) {
		ListNode tmpHead = new ListNode(-1);
		while(head != null) {
			ListNode next = head.next;
			head.next = tmpHead.next;
			tmpHead.next = head;
			head = next;
		}
		return tmpHead.next;
	}
}

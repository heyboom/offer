package jianzhioffer;

public class 反转链表 {

	public ListNode ReverseList(ListNode head) {
		ListNode pre = null, cur = head, tmp = null;
		while(cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}
}

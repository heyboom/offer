package jianzhioffer;

public class 链表中倒数第K个结点 {

	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k <= 0)
			return null;
		ListNode fast = head, late = head;
		while(--k > 0) {
			if(fast.next == null)
				return null;
			fast = fast.next;
		}
		while(fast.next != null) {
			fast = fast.next;
			late = late.next;
		}
		return late;
	}
}

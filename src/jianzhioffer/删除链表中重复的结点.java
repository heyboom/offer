package jianzhioffer;

public class 删除链表中重复的结点 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println(deleteDuplication(n1));
	}
	
	public static ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null)
			return null;
		ListNode tmpHead = new ListNode(0);
		tmpHead.next = pHead;
		ListNode pre = tmpHead;
		ListNode cur = tmpHead.next;
		while(cur != null) {
			if(cur.next != null && cur.next.val == cur.val) {
				while(cur.next != null && cur.next.val == cur.val) {
					cur = cur.next;
				}
				cur = cur.next;
				pre.next = cur;
			} else {
				cur = cur.next;
				pre = pre.next;
			}
		}
		return tmpHead.next;
	}
}

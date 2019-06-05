package jianzhioffer;

public class 链表中环的入口结点 {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//		n5.next = n4;
		System.out.println(EntryNodeOfLoop(n1));
	}
	
	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode MeetingNode = meetingNode(pHead);
		if(MeetingNode == null)
			return null;
		ListNode slow = MeetingNode;
		ListNode fast = MeetingNode.next;
		int count = 1;
		while(fast != slow) {
			fast = fast.next;
			count++;
		}
		fast = pHead;
		slow = pHead;
		while(count-- != 0) {
			fast = fast.next;
		}
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	
	public static ListNode meetingNode(ListNode pHead) {
		if(pHead == null || pHead.next == null)
			return null;
		ListNode fast = pHead.next.next;
		ListNode slow = pHead;
		while(fast != null && slow != null) {
			if(fast == slow)
				return fast;
			if(fast.next == null)
				return null;
			fast = fast.next.next;
			slow = slow.next;
		}
		return null;
	}
}

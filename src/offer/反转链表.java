package offer;

public class 反转链表 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		System.out.println(ReverseList(l1).val);
	}
	
	public static ListNode ReverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		ListNode ReversedHead = null;
		ListNode current = head;
		ListNode currentNext = null;
		ListNode currentPre = null;
		while(current != null) {
			currentNext = current.next;
			current.next = currentPre;
			if(currentNext == null) {
				ReversedHead = current;
			}
			currentPre = current;
			current = currentNext;
		}
		return ReversedHead;
	}
}

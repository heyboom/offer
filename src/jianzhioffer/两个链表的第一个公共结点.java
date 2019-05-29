package jianzhioffer;

public class 两个链表的第一个公共结点 {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null)
			return null;
		int count1 = 0;
		int count2 = 0;
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;
		while(p1 != null) {
			count1++;
			p1 = p1.next;
		}
		while(p2 != null) {
			count2++;
			p2 = p2.next;
		}
		int gap = 0;
		p1 = pHead1;
		p2 = pHead2;
		if(count1 > count2) {
			gap = count1 - count2;
			while(gap-- > 0) p1 = p1.next;
		} else {
			gap = count2 - count1;
			while(gap-- > 0) p2 = p2.next;
		}
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}

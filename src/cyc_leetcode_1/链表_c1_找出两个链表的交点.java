package cyc_leetcode_1;

public class 链表_c1_找出两个链表的交点 {
	//非递归版本
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		ListNode lA = headA;
		ListNode lB = headB;
		int lenA = 0, lenB = 0;
		while (lA != null){
			lenA++;
			lA = lA.next;
		}
		while (lB != null){
			lenB++;
			lB = lB.next;
		}
		if (lenA > lenB){
			int gap = lenA - lenB;
			while (gap > 0){
				headA = headA.next;
				gap--;
			}
		} else {
			int gap = lenB - lenA;
			while (gap > 0){
				headB = headB.next;
				gap--;
			}
		}
		while (headA != null && headB != null){
			if (headA == headB) return headA;
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
	
	//递归
	
}

package offer;

public class 两个链表的第一个公共结点 {

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1 == null || pHead2 == null)
			return null;
		int Len1 = FindListNodeLen(pHead1);
		int Len2 = FindListNodeLen(pHead2);
		ListNode tmp = Len1 > Len2 ? pHead1 : pHead2;
		int diff = Math.abs(Len1 - Len2);
		while(diff > 0) {
			tmp = tmp.next;
			diff--;
		}
		pHead1 = Len1 > Len2 ? tmp : pHead1;
		pHead2 = Len1 > Len2 ? pHead2 : tmp;
		while(pHead1 != pHead2 && pHead1 != null && pHead2 != null) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		if(pHead1 == null || pHead2 == null) {
			return null;
		}
		return pHead1;
	}
	
	public int FindListNodeLen(ListNode node) {
		int count = 0;
		if(node == null) {
			return count;
		}
		while(node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
}

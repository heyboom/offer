package offer;

public class 删除链表中重复的结点 {

	public ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null || pHead.next == null) {
			return pHead;
		}
		if(pHead.val == pHead.next.val) {
			ListNode node = pHead.next;
			while(node != null && node.val == pHead.val) {
				node = node.next;
			}
			return deleteDuplication(node);
		}else {
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
	}
}

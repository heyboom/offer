package cyc_leetcode_1;

public class 链表_c10_链表元素按奇偶聚集 {
	
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode oddNode = new ListNode(-1);
		ListNode evenNode = new ListNode(-1);
		ListNode oddHead = oddNode;
		ListNode evenHead = evenNode;
		boolean flag = true;
		while (head != null) {
			ListNode next = head.next;
			ListNode node = flag ? oddNode : evenNode;
			head.next = null;
			node.next = head;
			node = node.next;
			flag = !flag;
		}
		oddNode.next = evenHead.next;
		return oddHead.next;
	}
}

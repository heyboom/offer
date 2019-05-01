package offer;

public class 链表的倒数第K个结点 {

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
		System.out.println(FindKthToTail(l1, 5).val);
	}
	
	public static ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k < 1) {
			return null;
		}
		ListNode node = head;
		ListNode fastNode = head;
		k--;
		while(fastNode.next != null && k != 0) {
			fastNode = fastNode.next;
			k--;
		}
		if(fastNode == null || k != 0) {
			return null;
		}
		while(fastNode.next != null) {
			fastNode = fastNode.next;
			node = node.next;
		}
		return node;
	}
}

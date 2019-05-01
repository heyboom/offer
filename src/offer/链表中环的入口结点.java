package offer;

public class 链表中环的入口结点 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l3;
		ListNode tmp = EntryNodeOfLoop(l1);
	}
	
	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if(pHead == null || pHead.next == null)
			return null;
		ListNode fastNode = pHead.next.next;
		ListNode slowNode = pHead;
		while(fastNode != null && fastNode != slowNode) {
			if(fastNode.next != null && fastNode.next.next != null) {
				fastNode = fastNode.next.next;
				slowNode = slowNode.next;
			}else {
				break;
			}
		}
		if(fastNode == null || slowNode == null || fastNode != slowNode ) {
			return null;
		}
		//如果未返回,有环
		//计算环的结点数,count
		fastNode = fastNode.next;
		int count = 1;
		while(fastNode != slowNode) {
			fastNode = fastNode.next;
			count++;
		}
		//让fast结点行动count个结点
		fastNode = pHead;
		slowNode = pHead;
		while(count-- != 0) {
			fastNode = fastNode.next;
		}
		//同时移动,直到相遇,即为入口结点
		while(fastNode != slowNode) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}
		return fastNode;
	}
}

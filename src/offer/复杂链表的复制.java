package offer;

public class 复杂链表的复制 {

	public static void main(String[] args) {
		RandomListNode l1 = new RandomListNode(1);
		RandomListNode l2 = new RandomListNode(2);
		RandomListNode l3 = new RandomListNode(3);
		RandomListNode l4 = new RandomListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l1.random = l3;
		l2.random = l4;
		Clone(l1);
	}
	
	public static RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null)
			return null;
		//复制A-A'-B-B'-……
		RandomListNode loopNode = pHead;
		while(loopNode != null) {
			RandomListNode copyNode = new RandomListNode(loopNode.label);
			RandomListNode tmp = loopNode.next;
			loopNode.next = copyNode;
			copyNode.next = tmp;
			loopNode = tmp;
		}
		//设置随机指向
		loopNode = pHead;
		while(loopNode != null) {
			if(loopNode.random != null) {
				loopNode.next.random = loopNode.random.next;
			}
			loopNode = loopNode.next.next;
		}
		//拆分两个链表
		loopNode = pHead;
		RandomListNode newHead = pHead.next;
		while(loopNode != null) {
			RandomListNode nextOriginNode = loopNode.next.next;
			if(nextOriginNode == null) {
				loopNode.next.next = null;
				loopNode.next = null;
				break;
			}else {
				loopNode.next.next = nextOriginNode.next;
				loopNode.next = nextOriginNode;
				loopNode = loopNode.next;
			}
		}
		return newHead;
	}
}

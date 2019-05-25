package jianzhioffer;
/*
 * 注意注释流程
 */
public class 复杂链表的复制 {

	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		node1.next = node2;
		node2.next = node3;
		node1.random = node3;
		node3.next = node4;
		node3.random = node1;
		RandomListNode copy = Clone(node1);
		RandomListNode node = copy;
		while(node != null) {
			if(node.random != null) {
				System.out.println(node.label + "(" + node.random.label + "), ");
			} else {
				System.out.println(node.label + ", ");
			}
			node = node.next;
		}
	}
	
	public static RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null)
			return null;
		RandomListNode node = pHead;	// 1(3)->2->3(4)->4-NULL  括号内为随机指针
		while(node != null) {		// 复制成 1->1->2->2->3->3->4->4-NULL
			RandomListNode nodeCopy = new RandomListNode(node.label);
			nodeCopy.next = node.next;
			node.next = nodeCopy;
			node = nodeCopy.next;
		}
		node = pHead;	//设置random指针
		while(node != null) {
			if(node.random != null) {
				node.next.random = node.random.next;
			}
			node = node.next.next;
		}
		//拆分两条链表
		RandomListNode pHeadCopy = pHead.next;
		node = pHead;
		RandomListNode nodeCopy = pHeadCopy;
		while(nodeCopy.next != null) {
			node.next = nodeCopy.next;
			nodeCopy.next = nodeCopy.next.next;
			node = node.next;
			nodeCopy = nodeCopy.next;
		}
		node.next = nodeCopy.next;	//最终两条链表的结尾都是NULL
		return pHeadCopy;
	}

}

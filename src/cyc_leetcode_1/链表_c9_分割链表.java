package cyc_leetcode_1;

public class 链表_c9_分割链表 {

	public ListNode[] splitListToParts(ListNode root, int k) {
		ListNode[] nodes = new ListNode[k];
		int count = 0; 
		ListNode node = root;
		while (node != null) {
			count++;
			node = node.next;
		}
		int segSize = count / k; //每段大小
		int rmd = count % k;	// 余数多少，均匀分散，每段一个直至为0
		node = root;
		for(int index = 0; index < k; index++) {
			if (node == null) {
				nodes[index] = null;
				continue;
			}
			ListNode head = node;
			ListNode pre = node;
			int tmp = segSize;
			while (tmp-- > 0){		//每段大小固定
				pre = node;
				node = node.next;
			}
			if (rmd-- > 0) {	//如果有余数，分给每段一个，直至为0
				pre = node;
				node = node.next;
			}
			pre.next = null;
			nodes[index] = head;
		}
		return nodes;
	}
}

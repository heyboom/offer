package cyc_leetcode_1;

import java.util.Deque;
import java.util.LinkedList;

public class 链表_c7_两数相加 {

	/**
	假设两个链表一样长，不足的为0
	最后一步，虽然两个栈都空了，但是可能还会有carry，所以需要额外的加节点
	*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> stack1 = new LinkedList<>();
		Deque<Integer> stack2 = new LinkedList<>();
		while (l1 != null){
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null){
			stack2.push(l2.val);
			l2 = l2.next;
		}
		ListNode tmpHead = new ListNode(0);
		int carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
			int x = stack1.isEmpty() ? 0 : stack1.pop();
			int y = stack2.isEmpty() ? 0 : stack2.pop();
			int num = x + y + carry;
			ListNode node = new ListNode(num % 10);
			node.next = tmpHead.next;
			tmpHead.next = node;
			carry = num / 10;
		}
		return tmpHead.next;
	}
}

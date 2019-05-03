package jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Deque;

public class 从尾到头打印链表 {

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		Deque<Integer> stack = new LinkedList<>();
		while(listNode != null){
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}
}

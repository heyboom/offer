package jianzhioffer;

public class 合并两个排序的链表 {

	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null)	return list2;
		if(list2 == null)	return list1;
		ListNode head, node, tmp;
		if(list1.val < list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
		node = head;
		while(list1 != null && list2 != null) {
			if(list1.val < list2.val) {
				tmp = list1;
				list1 = list1.next;
			} else {
				tmp = list2;
				list2 = list2.next;
			}
			node.next = tmp;
			node = node.next;
		}
		node.next = list1 != null ? list1 : list2;
		return head;
	}
	
	// 递归
	public ListNode Merge2(ListNode list1,ListNode list2) {
		if(list1 == null)	return list2;
		if(list2 == null)	return list1;
		ListNode head = null;
		if(list1.val <= list2.val) {
			head = list1;
			head.next = Merge2(list1.next, list2);
		}else {
			head = list2;
			head.next = Merge2(list1, list2.next);
		}
		return head;
	}
}

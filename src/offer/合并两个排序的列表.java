package offer;

public class 合并两个排序的列表 {

	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null)	return list2;
		if(list2 == null)	return list1;
		ListNode head = null;
		if(list1.val <= list2.val) {
			head = list1;
			head.next = Merge(list1.next, list2);
		}else {
			head = list2;
			head.next = Merge(list1, list2.next);
		}
		return head;
	}
	
}

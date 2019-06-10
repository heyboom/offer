package cyc_leetcode_双指针;

public class c6_判断链表是否有环 {

	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next.next;
		while(fast != null && fast != slow) {
			slow = slow.next;
			fast = fast.next;
			if(fast == null)
				return false;
			fast = fast.next;
		}
		if(fast == null)
			return false;
		return true;
	}
}

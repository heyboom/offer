package cyc_leetcode_1;

public class 链表_c8_回文链表 {

	public boolean isPalindrome(ListNode head) {
		if (head == null) return true;
		ListNode other = cut(head);
		other = reverse(other);
		/*
			不用管奇偶，只需要考虑同时不等于Null的那部分就好
		*/
		while (head != null && other != null){
			if (head.val != other.val){
				return false;
			}
			head = head.next;
			other = other.next;
		}
		return true;
	}

	private ListNode cut(ListNode head){
		ListNode tmpHead = new ListNode(-1);
		tmpHead.next = head;
		ListNode fast = tmpHead;
		ListNode slow = tmpHead;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode other = slow.next;
		slow.next = null;
		return other;
	}

	private ListNode reverse(ListNode head){
		ListNode tmpHead = new ListNode(-1);
		while (head != null) {
			ListNode next = head.next;
			head.next = tmpHead.next;
			tmpHead.next = head;
			head = next;
		}
		return tmpHead.next;
	}
}

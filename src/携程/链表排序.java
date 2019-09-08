package 携程;

public class 链表排序 {

	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	}
	
    static ListNode partition(ListNode head,int m) {
        if (head == null) {
            return head;
        }
        ListNode newHead1 = new ListNode(-1);
        ListNode newHead2 = new ListNode(-1);
        newHead1.next = head;
        ListNode pre = newHead1, cur = head;
        ListNode p = newHead2;
        while (cur != null) {
            if (cur.val <= m) {
                ListNode next = cur.next;
                pre.next = next;
                p.next = cur;
//                cur.next = null;
                p = p.next;
                cur = next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        p.next = newHead1.next;
        return newHead2.next;
    }
}

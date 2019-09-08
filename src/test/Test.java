package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {

	 public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }

/*请完成下面这个函数，实现题目要求的功能
******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        if (head == null) {
            return head;
        }
        ListNode newHead1 = new ListNode(-1);
        newHead1.next = head;
        ListNode newHead2 = new ListNode(-1);
        ListNode pre = newHead1;
        ListNode cur = head;
        ListNode p = newHead2;
        while (cur != null) {
            if (cur.val <= m) {
                ListNode next = cur.next;
                pre.next = next;
                p.next = cur;
                cur.next = null;
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
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
              System.out.print(head.val);
              head=head.next;
              while(head!=null){
                    System.out.print(",");
                    System.out.print(head.val);
                    head=head.next;
              }
         }
         System.out.println();
    }
}

package jianzhioffer;

import java.util.ArrayDeque;
import java.util.Deque;

public class 用两个栈实现队列 {

	Deque<Integer> stack1 = new ArrayDeque<>();
	Deque<Integer> stack2 = new ArrayDeque<>();
	
	public void push(int node) {
		stack1.push(node);
	}
	
	public int pop() {
		if(stack2.isEmpty() && stack1.isEmpty())
			throw new RuntimeException("Queue is empty!");
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}

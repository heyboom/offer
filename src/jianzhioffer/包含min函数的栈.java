package jianzhioffer;

import java.util.Arrays;
import java.util.Stack;

public class 包含min函数的栈 {

	private int[] nodes = new int[16];
	private Stack<Integer> minNode = new Stack<>();
	private int size = 0;
	private int start = -1;
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void ensureCapacity() {
		if(size + 1 > nodes.length) {
			int oldLen = nodes.length;
			int newLen = oldLen + (oldLen >> 1);
			int[] newNodes = Arrays.copyOf(nodes, newLen);
			nodes = newNodes;
		}
	}
	
	public void push(int node) {
		ensureCapacity();
		if(minNode.isEmpty() || node < minNode.peek())
			minNode.push(node);
		nodes[++start] = node;
		size++;
	}
	
	public void pop() {
		if(isEmpty())
			return;
		if(nodes[start] == minNode.peek())
			minNode.pop();
		start--;
		size--;
	}
	
	public int top() {
		return nodes[start];
	}
	
	public int min() {
		return minNode.peek();
	}
}

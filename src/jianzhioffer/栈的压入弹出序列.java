package jianzhioffer;
import java.util.ArrayDeque;

public class 栈的压入弹出序列 {

	public static void main(String[] args) {
		int[] pushA = {1, 2, 3, 4, 5};
		int[] popA = {5, 4, 3, 2, 1};
		System.out.println(IsPopOrder(pushA, popA));
	}
	
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA == null || popA == null)
			return false;
		if(pushA.length != popA.length || pushA.length == 0)
			return false;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i = 0, j = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while(stack.peek() == popA[j]) {
				stack.pop();
				j++;
				if(j == popA.length)	//保证到最后不会出现 stack.peek() == popA[j] == null
					break;
			}
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
}

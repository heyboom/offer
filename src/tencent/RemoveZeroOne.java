package tencent;

import java.util.Stack;

/*
 * 题目：
 * 一个只包含0,，1的字符串，如1100，迭代的去除掉0，1对，输出最终剩下的长度。
 * 输入1100，输出（长度）0
 * 输入10100，输出（长度）1
 * 
 * 思路：
 * 利用栈来保存字符串，依次入栈，如果产生01对，则出栈
 */
public class RemoveZeroOne {

	public static void main(String[] args) {
		System.out.println(remove("00000"));
	}
	
	public static int remove(String str) {
		if(str == null || str.length() == 0) 
			return 0;
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if(stack.size() == 0 || c == stack.peek()) {
				stack.push(c);
			} else {
				stack.pop();
			}
		}
		return stack.size();
	}
}

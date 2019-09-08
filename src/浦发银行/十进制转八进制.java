package 浦发银行;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 十进制转八进制 {

	public static void main(String[] args) {
		System.out.println(change(16));
	}
	
	public static List<Integer> change(Integer num){
		Deque<Integer> stack = new ArrayDeque<>();
		while (num != 0) {
			int n = (num & 7);
			stack.push(n);
			num = num >> 3;
		}
		return new ArrayList<Integer>(stack);
	}
}

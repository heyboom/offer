package jianzhioffer;

/*
 * 注意窗口大小的判断方法
 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class 滑动窗口的最大值 {

	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		int size = 3;
		System.out.println(maxInWindows(num, size));
	}
	public static ArrayList<Integer> maxInWindows(int [] num, int size){
		ArrayList<Integer> list = new ArrayList<>();
		if(num == null || num.length == 0 || size <= 0)
			return list;
		Deque<Integer> deque = new LinkedList<>();
		for(int i = 0; i < num.length; i++) {
			if(!deque.isEmpty()) {
				while(!deque.isEmpty() && num[i] > num[deque.peekLast()]) {
					deque.pollLast();
				}
			}
			deque.offerLast(i);
			if(deque.peekLast() - deque.peekFirst() >= size) {
				deque.pollFirst();
			}
			if(i >= size - 1) {
				list.add(num[deque.peekFirst()]);
			}
		}
		return list;
	}
}

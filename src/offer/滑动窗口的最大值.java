package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 *  {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class 滑动窗口的最大值 {

	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		int size = 3;
		System.out.println(maxInWindows(num, size));
	}
	
	public static ArrayList<Integer> maxInWindows(int [] num, int size){
		ArrayList<Integer> list = new ArrayList<>();
		if(num == null || num.length == 0 || size < 1 || size > num.length)
			return list;
		Deque<Integer> queue = new LinkedList<>();
		for(int i = 0; i < num.length; i++) {
			if(queue.isEmpty()) {
				queue.offer(i);
			}
			if(i - queue.peek() >= size) {
				queue.poll();
			}
			while(!queue.isEmpty() && num[i] >= num[queue.getLast()])	queue.pollLast();
			queue.offer(i);
			if(i >= size - 1 && !queue.isEmpty())
				list.add(num[queue.peek()]);
		}
		return list;
	}
}

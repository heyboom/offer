package jianzhioffer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class o41_数据流的中位数 {

	public static void main(String[] args) {
		Integer[] nums = new Integer[]{5,2,3,4,1,6,7,0,8};
		for(Integer num : nums) {
			System.out.println(num);
			Insert(num);
			System.out.println(GetMedian());
		}
	}
	
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
		});
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
		});
	
	private static int count = 0;
	
	public static void Insert(Integer num) {
		if((count & 1) == 0) {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		} else {
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		}
		count++;
	}
	
	public static Double GetMedian() {
		if(count == 0)
			return null;
		if((count & 1) != 0) {
			return Double.valueOf(minHeap.peek());
		} else {
			return (minHeap.peek() + maxHeap.peek()) / 2.0d;
		}
	}
}

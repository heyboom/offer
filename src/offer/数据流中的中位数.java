package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中的中位数 {
	
	public static void main(String[] args) {
		int[] arr = {5,2,3,4,1,6,7,0,8};
		for(int i = 0; i < 1; i++) {
			Insert(arr[i]);
		}
		System.out.println(GetMedian());
	}

	private static int count = 0;
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});

	public static void Insert(Integer num) {
		count++;
		if((count & 1) == 1) {
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		}else {
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		}
	}
	
	public static Double GetMedian() {
		if(count <= 0) {
			throw new RuntimeException("no median number");
		}
		if((count & 1) == 1) {
			return maxHeap.peek() / 1.0;
		}else {
			return ((maxHeap.peek() + minHeap.peek()) / 2.0);
		}
	}
}

package offer;

import java.util.*;
public class 最小的K个数 {

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if(input == null || input.length == 0 || k == 0 || k > input.length) {
			return list;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		for(int i = 0; i < input.length; i++) {
			if(maxHeap.size() < k) {
				maxHeap.offer(input[i]);
			}else if(input[i] < maxHeap.peek()){
				maxHeap.poll();
				maxHeap.offer(input[i]);
			}
		}
		list.addAll(maxHeap);
		return list;
	}
	
}

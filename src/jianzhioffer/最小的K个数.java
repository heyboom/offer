package jianzhioffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {

	public static void main(String[] args) {
		int[] input = {4,5,1,6,2,7,3,8};
		int k = 4;
		System.out.println(GetLeastNumbers_Solution(input, k));
	}
	
	public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		if(input == null || k <= 0 ||input.length < k)
			return list;
		PriorityQueue<Integer> minestHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			});
		
		for(int i = 0; i < k; i++) {
			minestHeap.offer(input[i]);
		}
		for(int i = k; i < input.length; i++) {
			if(input[i] < minestHeap.peek()) {
				minestHeap.poll();
				minestHeap.offer(input[i]);
			}
		}
		list.addAll(minestHeap);
		return list;
	}
}

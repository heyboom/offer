package cyc_leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 排序c1_Kth_Element {

	//排序
	public int findKthLargest1(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	
	//堆排序
	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for(int num : nums) {
			heap.offer(num);
			if(heap.size() > k) {
				heap.poll();
			}
		}
		return heap.peek();
	}
	
	//快速排序
	public int findKthLargest3(int[] nums, int k) {
		int low = 0;
		int high = nums.length - 1;
		while(low < high) {
			int pivotPos = partition(nums, low, high);
			if(pivotPos + 1 == k) {
				break;
			} else if (pivotPos + 1 < k){
				low = pivotPos + 1;
			} else {
				high = pivotPos - 1;
			}
		}
		return nums[k - 1];
	}
	
	public int partition(int[] nums, int low, int high) {
		int pivot = nums[low];
		while(low < high) {
			while(low < high && nums[high] <= pivot) high--;
			nums[low] = nums[high];
			while(low < high && nums[low] >= pivot) low++;
			nums[high] = nums[low];
		}
		nums[low] = pivot;
		return low;
	}
}

package sort2;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static void bubbleSort(int[] nums) {
		if(nums == null || nums.length == 0)
			return;
		Boolean canStop;
		int tmp;
		for(int i = 0; i < nums.length - 1; i++) {
			canStop = true;
			for(int j = nums.length - 1; j > i; j--) {
				if(nums[j] < nums[j - 1]) {
					canStop = false;
					tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}
			}
			if(canStop)
				return;
		}
	}
}

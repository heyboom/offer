package cyc_leetcode_双指针;

import java.util.Arrays;

public class c1_有序数组的TwoSum {

	public static void main(String[] args) {
		int[] numbers = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(numbers, target)));
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = {0, 0};
		if(numbers == null || numbers.length == 0)
			return result;
		int left = 0, right = numbers.length - 1;
		while(left < right) {
			int cur = numbers[left] + numbers[right];
			if(cur == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			} else if (cur < target) {
				left++;
			} else {
				right--;
			}
		}
		return result;
	}
}

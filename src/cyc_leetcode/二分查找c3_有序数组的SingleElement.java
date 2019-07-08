package cyc_leetcode;

public class 二分查找c3_有序数组的SingleElement {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,4,4,5,5,9};
		System.out.println(singleNonDuplicate(nums));
	}
	
	public static int singleNonDuplicate(int[] nums) {
		int l = 0, h = nums.length - 1;
		while(l < h) {
			int m = l + (h - l) / 2;
			if(m % 2 != 0) {
				m--;
			}
			if (nums[m] == nums[m + 1]) {
				l = m + 2;
			} else {
				h = m;
			}
		}
		return nums[l];
	}
}

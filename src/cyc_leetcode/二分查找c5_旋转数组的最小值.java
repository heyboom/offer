package cyc_leetcode;

public class 二分查找c5_旋转数组的最小值 {

	
	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			throw new RuntimeException("Invalid params");
		}
		int i = 1;
		for(; i < nums.length; i++) {
			if(nums[i] < nums[i - 1])
				break;
		}
		if(i == nums.length)
			return nums[0];
		int low = 0, high = nums.length - 1;
		while (high - low > 1) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high]) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return nums[high];
	}
	
	//cyc的骚操作
	public int findMin2(int[] nums) {
		int l = 0, h = nums.length - 1;
		while(l < h) {
			int m = l + (h - l) / 2;
			if(nums[m] < nums[h]) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return nums[l];
	}
}

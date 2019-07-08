package cyc_leetcode;

public class 二分查找c6_查找区间 {

	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return new int[] {-1, -1};
		}
		int l = 0, h = nums.length - 1;
		while(l < h) {
			int m = l + (h - l) / 2;
			if(nums[m] >= target) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		if(nums[h] != target) {
			return new int[] {-1, -1};
		}
		int left = h;
		l = 0; h = nums.length - 1;
		while(l < h) {
			int m = h - (h - l) / 2;
			if(nums[m] <= target) {
				l = m;
			} else {
				h = m - 1;
			}
		}
		int right = l;
		return new int[] {left, right};
	}
	
	//cyc
	public int[] searchRange2(int[] nums, int target) {
		int first = binarySearch(nums, target);
		int last = binarySearch(nums, target + 1) - 1;
		if(first == nums.length || nums[first] != target) {
			return new int[] {-1, -1};
		}else {
			return new int[] {first, Math.max(first, last)};
		}
	}
	
	public int binarySearch(int[] nums, int target) {
		int l = 0, h = nums.length; // 注意h的初始值
		while(l < h) {
			int m = l + (h - l) / 2;
			if (nums[m] >= target) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return l;
	}
}

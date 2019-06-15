package cyc_leetcode;

public class 排序c3_荷兰国旗问题 {

	public void sortColors(int[] nums) {
		int begin = -1, cur = 0, end = nums.length;
		while(cur < end) {
			if(nums[cur] == 0) {
				swap(nums, ++begin, cur++);
			} else if (nums[cur] == 2) {
				swap(nums, --end, cur);
			} else{
				cur++;
			}
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

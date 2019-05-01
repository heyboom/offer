package leetcode;

public class 打家劫舍二213 {

	public int rob(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
	}
	
	public int robHelper(int[] nums, int first, int last) {
		int pre1 = 0, pre2 = 0;
		for(int i = first; i <= last; i++) {
			int tmp = pre1;
			pre1 = Math.max(pre2 + nums[i], pre1);
			pre2 = tmp;
		}
		return pre1;
	}
}

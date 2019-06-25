package cyc_leetcode;

public class 贪心c9_修改一个数成为非递减数组 {
	public boolean checkPossibility(int[] nums) {
		if(nums == null)
			return false;
		int cnt = 0;
		for(int i = 1; i < nums.length && cnt < 2; i++) {
			if(nums[i] >= nums[i - 1]) {
				continue;
			}
			if(i >= 2 && nums[i - 2] > nums[i]) {
				nums[i] = nums[i - 1];
			} else {
				nums[i - 1] = nums[i];
			}
			cnt++;
		}
		return cnt <= 1;
	}
}

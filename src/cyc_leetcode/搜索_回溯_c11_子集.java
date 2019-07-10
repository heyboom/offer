package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c11_子集 {

	public List<List<Integer>> subsets(int[] nums) {
		List<Integer> result = new ArrayList<>();
		List<List<Integer>> results = new ArrayList<>();
		for(int n = 0; n <= nums.length; n++) {
			backtracing(nums, n, 0, result, results);
		}
		return results;
	}
	
	private void backtracing(int[] nums, int n, int start, List<Integer> result, List<List<Integer>> results) {
		if (n < 0) {
			return;
		}
		if (n == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			result.add(nums[i]);
			backtracing(nums, n - 1, i + 1, result, results);
			result.remove(result.size() - 1);
		}
	}
}

package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 搜索_回溯_c12_含有相同元素求子集 {

	public static void main(String[] args) {
		搜索_回溯_c12_含有相同元素求子集 demo = new 搜索_回溯_c12_含有相同元素求子集();
		int[] nums = {1, 2, 2};
		System.out.println(demo.subsetsWithDup(nums));
	}
	
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		for(int size = 0; size <= nums.length; size++) {
			backtracing(nums, size, 0, visited, result, results);
		}
		return results;
	}
	
	private void backtracing(int[] nums, int size, int start, boolean[] visited, List<Integer> result, List<List<Integer>> results) {
		if (size < 0) {
			return;
		}
		if (size == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
				continue;
			}
			result.add(nums[i]);
			visited[i] = true;
			backtracing(nums, size - 1, i + 1, visited, result, results);
			result.remove(result.size() - 1);
			visited[i] = false;
		}
	}
}

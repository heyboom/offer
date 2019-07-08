package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c5_排列 {

	public static void main(String[] args) {
		搜索_回溯_c5_排列 demo = new 搜索_回溯_c5_排列();
		int[] nums = {1,2,3};
		System.out.println(demo.permute(nums));
	}
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		int n = nums.length;
		boolean[] visited = new boolean[n];
		doPermute(nums, 0, visited, result, results);
		return results;
	}
	
	public void doPermute(int[] nums, int k, boolean[] visited, List<Integer> result, List<List<Integer>> results) {
		if(result.size() == nums.length) {
			results.add(new ArrayList<>(result));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if(visited[i]) {
				continue;
			}
			result.add(nums[i]);
			visited[i] = true;
			doPermute(nums, k + 1, visited, result, results);
			visited[i] = false;
			result.remove(k);
		}
	}
}

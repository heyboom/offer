package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 搜索_回溯_c9_含有相同元素的组合求和 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Arrays.sort(candidates);
		boolean[] visited = new boolean[candidates.length];
		backtracing(candidates, target, 0, result, results, visited);
		return results;
	}
	
	private void backtracing(int[] candidates, int target, int start,
			List<Integer> result, List<List<Integer>> results, boolean[] visited) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		for(int i = start; i < candidates.length; i++) {
			if(visited[i]) {
				continue;
			}
			if(i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
				continue;
			}
			visited[i] = true;
			result.add(candidates[i]);
			backtracing(candidates, target - candidates[i], i + 1, result, results, visited);
			visited[i] = false;
			result.remove(result.size() - 1);
		}
	}
}

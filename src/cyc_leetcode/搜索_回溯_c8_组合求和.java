package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c8_组合求和 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		backtracing(candidates, target, 0, result, results);
		return results;
	}
	
	private void backtracing(int[] candidates, int target, int start, List<Integer> result, List<List<Integer>> results) {
		if(target < 0) {
			return;
		}
		if(target == 0) {
			results.add(new ArrayList<>(result));
			start++;
			return;
		}
		for(int i = start; i < candidates.length; i++) {
			result.add(candidates[i]);
			backtracing(candidates, target - candidates[i], i, result, results);
			result.remove(result.size() - 1);
		}
	}
}

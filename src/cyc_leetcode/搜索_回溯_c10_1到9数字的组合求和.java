package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c10_1到9数字的组合求和 {

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		backtracing(k, n, 1, result, results);
		return results;
	}
	
	private void backtracing(int k, int n, int start, List<Integer> result, List<List<Integer>> results) {
		if (n < 0) {
			return;
		}
		if (n == 0 && result.size() == k) {
			results.add(new ArrayList<>(result));
			return;
		}
		for(int i = start; i <= 9; i++) {
			result.add(i);
			backtracing(k, n - i, i + 1, result, results);
			result.remove(result.size() - 1);
		}
	}
}

package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c7_组合 {

	public static void main(String[] args) {
		搜索_回溯_c7_组合 demo = new 搜索_回溯_c7_组合();
		System.out.println(demo.combine(4, 2));
	}
	
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		doCombine(n, k, 1, result, results);
		return results;
	}
	
	private void doCombine(int n, int k, int start, List<Integer> result, List<List<Integer>> results) {
		if(k == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		for(int i = start; i <= n - k + 1; i++) {
			result.add(i);
			doCombine(n , k - 1, i + 1,result, results);
			result.remove(result.size() - 1);
		}
	}
}

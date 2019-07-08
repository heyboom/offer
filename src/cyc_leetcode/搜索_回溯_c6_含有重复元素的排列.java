package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//visited的用法：
//https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
//chenxingyustar的评论

public class 搜索_回溯_c6_含有重复元素的排列 {

	public static void main(String[] args) {
		搜索_回溯_c6_含有重复元素的排列 demo = new 搜索_回溯_c6_含有重复元素的排列();
		int[] nums = {1,1,2};
		System.out.println(demo.permuteUnique(nums));
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		backTracing(nums, 0, visited, result, results);
		return results;
	}
	
	private void backTracing(int[] nums, int k, boolean[] visited, List<Integer> result, List<List<Integer>> results) {
		if(result.size() == nums.length) {
			results.add(new ArrayList<>(result));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if(visited[i]) {
				continue;
			}
			if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) { //注意visited的用法
				continue;
			}
			result.add(nums[i]);
			visited[i] = true;
			backTracing(nums, k + 1, visited, result, results);
			result.remove(k);
			visited[i] = false;
		}
	}
}

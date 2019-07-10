package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c13_分割字符串使得每个部分都是回文数 {

	public List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<>();
		List<String> result = new ArrayList<>();
		backtracing(s, result, results);
		return results;
	}
	
	private void backtracing(String s, List<String> result, List<List<String>> results) {
		if (s.length() == 0) {
			results.add(new ArrayList<>(result));
			return;
		}
		for(int i = 0; i < s.length(); i++) {
			if(isPalindrome(s, 0, i)) {
				result.add(s.substring(0, i + 1));
				backtracing(s.substring(i + 1, s.length()), result, results);
				result.remove(result.size() - 1);
			}
		}
	}
	
	private boolean isPalindrome(String s, int start, int end) {
		while(start < end) {
			if(s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}

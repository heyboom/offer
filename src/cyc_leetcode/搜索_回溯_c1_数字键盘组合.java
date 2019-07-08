package cyc_leetcode;

import java.util.ArrayList;
import java.util.List;

public class 搜索_回溯_c1_数字键盘组合 {

	private final String[] Keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public List<String> letterCombinations(String digits) {
		List<String> results = new ArrayList<>();
		if(digits == null || digits.isEmpty()) {
			return results;
		}
		dfs(new StringBuilder(), results, digits);
		return results;
	}
	
	private void dfs(StringBuilder prefix, List<String> results, final String digits) {
		if(prefix.length() == digits.length()) {
			results.add(prefix.toString());
			return;
		}
		int curDigit = digits.charAt(prefix.length()) - '0';
		String letters = Keys[curDigit];
		for(char c : letters.toCharArray()) {
			prefix.append(c);
			dfs(prefix, results, digits);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}

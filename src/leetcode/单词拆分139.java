package leetcode;

import java.util.List;

public class 单词拆分139 {

	public boolean wordBreak(String s, List<String> wordDict) {
		if(s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty())
			return false;
		int maxDictLen = 0;
		for(String sw : wordDict) {
			if(sw.length() > maxDictLen)
				maxDictLen = sw.length();
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i <= s.length(); i++)
			for(int j = i - 1; j >= 0 && j >= (i - maxDictLen); j--) {
				if(dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		return dp[s.length()];
	}
}


/*
 * 	public boolean wordBreak(String s, List<String> wordDict) {
		if(s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty())
			return false;
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for(int i = 1; i <= s.length(); i++)
			for(int j = 0; j < i; j++) {
				if(dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		return dp[s.length()];
	}
 */

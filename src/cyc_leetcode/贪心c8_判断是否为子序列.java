package cyc_leetcode;

public class 贪心c8_判断是否为子序列 {

	//双指针
	public boolean isSubsequence(String s, String t) {
		if(s == null || t == null)
			return false;
		int sIndex = 0, tIndex = 0;
		while(sIndex < s.length()) {
			while(tIndex < t.length() && t.charAt(tIndex) != s.charAt(sIndex)) {
				tIndex++;
			}
			if(tIndex == t.length())
				return false;
			sIndex++;
			tIndex++;
		}
		return true;
	}
	
	//cyc骚操作
	public boolean isSubsequence2(String s, String t) {
		if(s == null || t == null)
			return false;
		int index = -1;
		for(char c : s.toCharArray()) {
			index = t.indexOf(c, index + 1);
			if(index == -1)
				return false;
		}
		return true;
	}
}

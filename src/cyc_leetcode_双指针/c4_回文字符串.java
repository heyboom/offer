package cyc_leetcode_双指针;
/*
 * abca
 */
public class c4_回文字符串 {

	public boolean validPalindrome(String s) {
		if(s == null)
			return false;
		for(int left = 0, right = s.length() - 1; left <= right; left++, right--) {
			if(s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
		}
		return true;
	}
	
	public boolean isPalindrome(String s, int left, int right) {
		for(; left <= right; left++, right--) {
			if(s.charAt(left) != s.charAt(right))
				return false;
		}
		return true;
	}
}

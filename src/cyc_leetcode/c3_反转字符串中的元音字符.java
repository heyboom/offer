package cyc_leetcode;

public class c3_反转字符串中的元音字符 {

	public String reverseVowels(String s) {
		if(s == null)
			return null;
		StringBuilder sb = new StringBuilder(s);
		String vowels = "aeiouAEIOU";
		int left = 0;
		int right = s.length() - 1;
		while(left < right) {
			while(left < right && !vowels.contains(sb.charAt(left) + "")) {
				left++;
			}
			while(left < right && !vowels.contains(sb.charAt(right) + "")) {
				right--;
			}
			char tmp = sb.charAt(left);
			sb.setCharAt(left, sb.charAt(right));
			sb.setCharAt(right, tmp);
			left++;
			right--;
		}
		return sb.toString();
	}
}

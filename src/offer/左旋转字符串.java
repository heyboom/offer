package offer;

/*
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */

public class 左旋转字符串 {

	public String LeftRotateString(String str,int n) {
		if(str == null || str.isEmpty() || n < 0) {
			return "";
		}
		char[] chars = str.toCharArray();
		Reverse(chars, 0, str.length() - 1);
		Reverse(chars, 0, str.length() - n - 1);
		Reverse(chars, str.length() - n, str.length() - 1);
		return String.valueOf(chars);
	}
	
	private void Reverse(char[] chars, int left, int right) {
		if(chars == null || chars.length == 0)
			return;
		while(left < right) {
			char tmp = chars[left];
			chars[left] = chars[right];
			chars[right] = tmp;
			left++;
			right--;
		}
	}
}

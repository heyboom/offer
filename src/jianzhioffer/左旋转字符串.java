package jianzhioffer;

public class 左旋转字符串 {

	public String LeftRotateString(String str,int n) {
		if(str == null || str.length() == 0 || n < 0 || n > str.length())
			return "";
		StringBuilder sb = new StringBuilder(str);
		Reverse(sb, 0, sb.length() - 1);
		Reverse(sb, 0, sb.length() - n - 1);
		Reverse(sb, sb.length() - n, sb.length() - 1);
		return sb.toString();
	}
	
	public static void Reverse(StringBuilder sb, int low, int high) {
		while(low < high) {
			char tmp = sb.charAt(low);
			sb.setCharAt(low, sb.charAt(high));
			sb.setCharAt(high, tmp);
			low++;
			high--;
		}
	}
}

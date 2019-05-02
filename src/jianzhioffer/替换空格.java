package jianzhioffer;

public class 替换空格 {

	// 剑指offer的意思是，要用从前向后遍历空格次数，再从后向前移动
	// 要注意，newLen = oldLen + 2 * blankNum
	public static String replaceSpace(StringBuffer str) {
		if(str == null || str.length() == 0)
			return "";
		int blankNum = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				blankNum++;
			}
		}
		int oldIndex = str.length() - 1;
		int newLen = str.length() + 2 * blankNum;
		int newIndex = newLen - 1;
		str.setLength(newLen);
		for(;oldIndex >= 0; oldIndex--, newIndex--) {
			if (str.charAt(oldIndex) == ' ') {
				str.setCharAt(newIndex, '0');
				str.setCharAt(--newIndex, '2');
				str.setCharAt(--newIndex, '%');
			} else {
				str.setCharAt(newIndex, str.charAt(oldIndex));
			}
		}
		return str.toString();
	}
	
	public static String replaceSpace2(StringBuffer str) {
		if(str == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}

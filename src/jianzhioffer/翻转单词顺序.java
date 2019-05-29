package jianzhioffer;

public class 翻转单词顺序 {

	public static void main(String[] args) {
		String str = "Wonderful";
		System.out.println(ReverseSentence(str));
	}
	
	public static String ReverseSentence(String str) {
		if(str == null || str.length() == 0)
			return "";
		StringBuilder sb = new StringBuilder(str);
		Reverse(sb, 0, sb.length() - 1);
		for(int i = 0, oldj = 0; i <= sb.length(); i++) {
			if(i == sb.length() || sb.charAt(i) == ' ') {
				Reverse(sb, oldj, i - 1);
				oldj = i + 1;
			}
		}
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

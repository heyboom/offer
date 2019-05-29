package jianzhioffer;

public class 表示数值的字符串 {

	public static void main(String[] args) {
		String s = "3.e3";
		char[] str = s.toCharArray();
		System.out.println(isNumeric(str));
	}
public static boolean isNumeric(char[] str) {
	String numStr = String.valueOf(str);
	return numStr.matches("[\\+\\-]?\\d+(\\.\\d*)?([eE][\\+\\-]?\\d+)?")
			|| numStr.matches("[\\+\\-]?\\.\\d+([eE][\\+\\-]?\\d+)?");
}
}


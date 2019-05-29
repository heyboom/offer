package jianzhioffer;

public class 把字符串转化成整数 {

	public static void main(String[] args) {
		System.out.println(StrToInt("-123"));
	}
	
	public static int StrToInt(String str) {
		if(str == null || str.length() == 0)
			return 0;
		int num = 0;
		int index = 0;
		if(str.charAt(0) == '+' || str.charAt(0) == '-') {
			if(str.length() < 2)
				return 0;
			index++;
		}
		for(;index < str.length(); index++) {
			if(str.charAt(index) - '0' < 0 || str.charAt(index) - '0' > 9) {
				return 0;
			}
			num = num * 10 + str.charAt(index) - '0';
		}
		if(str.charAt(0) == '-') {
			num *= -1;
		}
		return num;
	}
}

package offer;

public class 把字符串转换成整数 {

	public static void main(String[] args) {
		char c = '9';
		System.out.println("".length());
	}
	
	/*
	 * z边界条件：
	 * zNull或者空字符
	 * z正负号和数字
	 * z只有正负号
	 * z大数字溢出
	 * z0和非法输入的区别（牛客统一返回0）
	 */
	public static int StrToInt(String str) {
		if(str == null || str.length() == 0)
			return 0;
		Integer num = 0;
		int index = 0;
		if(str.charAt(index) == '+' || str.charAt(index) == '-') {
			if(str.length() == 1)
				return 0;
			index++;
		}
		for(; index < str.length(); index++) {
			if(str.charAt(index) < '0' || str.charAt(index) > '9') {
				return 0;
			}
			num = num * 10 + (str.charAt(index) - '0');
		}
		if(str.charAt(0) == '-') {
			num *= -1;
		}
		return num;
	}
	
}

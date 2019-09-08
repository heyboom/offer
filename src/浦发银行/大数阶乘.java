package 浦发银行;

import java.math.BigDecimal;

public class 大数阶乘 {

	public static void main(String[] args) {
		BigDecimal bd4 = new BigDecimal(4);
		System.out.println(factorial(bd4));
	}
	
	public static BigDecimal factorial(BigDecimal n) {
		BigDecimal bd1 = new BigDecimal(1);
		BigDecimal result = bd1;
		while (n.compareTo(bd1) > 0) {
			result = result.multiply(n);
			n = n.subtract(bd1);
		}
		return result;
	}
	
}

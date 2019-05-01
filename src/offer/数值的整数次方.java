package offer;

import javax.management.RuntimeErrorException;

/*
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */

public class 数值的整数次方 {
	
	public double Power(double base, int exponent) {
		if(equal(base, 0)) {
			if(exponent >= 0) {
				return 0.0;
			}else {
				throw new RuntimeException("Invalid exponent");
			}
		}
		double result = 0.0;
		if(exponent < 0) {
			result = 1.0 / PowerCore(base, Math.abs(exponent));
		}else {
			result = PowerCore(base, exponent);
		}
		return result;
	}
	
	public double PowerCore(double base, int exponent) {
		if(exponent == 0) {
			return 1;
		}
		if(exponent == 1) {
			return base;
		}
		double result = PowerCore(base, exponent >> 1);
		result *= result;
		if((exponent & 1) == 1) {
			result *= base;
		}
		return result;
	}
	
	public boolean equal(double num1, double num2) {
		if(num1 - num2 > -0.000001 && num1 - num2 < 0.000001) {
			return true;
		}
		return false;
	}
}

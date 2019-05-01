package offer;

import java.util.Arrays;

public class 扑克牌顺子 {

	public static void main(String[] args) {
		System.out.println(isContinuous(new int[]{1,2,3,4,5}));
	}
	
	public static  boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length != 5)
			return false;
		Arrays.sort(numbers);
		int zeroNum = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] < 0 || numbers[i] > 13)
				return false;
			if(numbers[i] == 0) {
				zeroNum++;
			}
		}
		if(zeroNum > 4)
			return false;
		int gapNum = 0;
		for(int j = numbers.length - 1; j > 0 && numbers[j - 1] != 0; j--) {
			if(numbers[j] - numbers[j - 1] == 0) {
				return false;
			}else {
				gapNum += numbers[j] - numbers[j - 1] - 1;
			}
		}
		if(zeroNum >= gapNum)
			return true;
		return false;
	}
	
}

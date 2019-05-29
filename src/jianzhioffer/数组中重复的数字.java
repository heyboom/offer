package jianzhioffer;

public class 数组中重复的数字 {

	public boolean duplicate(int numbers[],int length,int [] duplication) {
		if(numbers == null || length < 1)
			return false;
		for(int i = 0; i < length; i++) {
			if(numbers[i] < 0 || numbers[i] > length - 1)
				return false;
		}
		
		for(int i = 0; i < length; i++) {
			if(numbers[i] != i) {
				int index = numbers[i];
				if(numbers[index] == index) {
					duplication[0] = index;
					return true;
				}
				numbers[i] = numbers[index];
				numbers[index] = index;
			}
		}
		return false;
	}
}

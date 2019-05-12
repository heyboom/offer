package jianzhioffer;

public class 调整数组顺序使奇数位于偶数之前 {

	public void reOrderArray(int [] array) {
		if(array == null || array.length == 0)
			return;
		int[] odd = new int[array.length];
		int[] even = new int[array.length];
		int oddLen = 0, evenLen = 0;
		for(int i = 0; i < array.length; i++)
			if ((array[i] & 1) != 0) {
				odd[oddLen++] = array[i];
			} else {
				even[evenLen++] = array[i];
			}
		int index = 0, oddIndex = 0;
		while(index < oddLen) {
			array[index++] = odd[oddIndex++];
		}
		int evenIndex = index - oddLen;
		while(evenIndex < evenLen) {
			array[index++] = even[evenIndex++];
		}
	}
}

package sort;

import java.util.Arrays;

public class BubbleSortDemo {
	
	public static void main(String[] args) {
		int[] data = {9,4,6,5,99,46,88,76,3,77};
		System.out.println("排序前:" + Arrays.toString(data));
		bubbleSort(data);
		System.out.println("排序后:" + Arrays.toString(data));
	}
	
	public static void bubbleSort (int[] data) {
		Boolean flag = true;
		for(int i = 0; i < data.length - 1; i++) {
			for(int j = data.length - 1; j > i; j--) {
				if(data[j] < data[j - 1]) {
					int temp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = temp;
					flag = false;
				}
			}
			if(flag) {
				return;				
			}
		}
	}
	
}

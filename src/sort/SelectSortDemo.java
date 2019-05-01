package sort;

import java.util.Arrays;

public class SelectSortDemo {
	
	public static void main(String[] args) {
		int[] data = {9,4,6,5,99,46,88,76,3,77};
		System.out.println("排序前:" + Arrays.toString(data));
		selectSort(data);
		System.out.println("排序后:" + Arrays.toString(data));
	}
	
	public static void selectSort (int[] data) {
		int i, j, min;
		for(i = 0; i < data.length - 1; i++) {
			min = i;
			for(j = i + 1; j < data.length; j++) {
				if(data[j] < data[min]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = data[i];
				data[i] = data[min];
				data[min] = temp;
			}
		}
	}
}

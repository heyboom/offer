package sort;

import java.util.Arrays;
/*
 * L22 j >= 0 && data[j] >= temp 两个条件一个都不能少，且j >= 0  要在前面，
 * 要不然data[j]会数组越界
 */
public class InsertSortDemo {
	public static void main(String[] args) {
		int[] data = {9,4,6,5,99,46,88,76,3,77};
		System.out.println("排序前:" + Arrays.toString(data));
		insertDirectlySort(data);
		System.out.println("排序后:" + Arrays.toString(data));
	}
	public static void insertDirectlySort(int[] data) {
		int i,j;
		for(i = 1; i < data.length; i++) {
			if(data[i] < data[i - 1]) {
				int temp = data[i];
				for(j = i - 1; j >= 0 && data[j] > temp; j--) {
					data[j + 1] = data[j];
				}
				data[j + 1] = temp;
			}
		}
	}
}

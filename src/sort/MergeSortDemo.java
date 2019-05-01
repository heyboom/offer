package sort;

import java.util.Arrays;

public class MergeSortDemo {
	
	public static void main(String[] args) {
		int[] data = {9,4,6,5,99,46,88,76,3,77};
		System.out.println("排序前:" + Arrays.toString(data));
		mergeSort(data);
		System.out.println("排序后:" + Arrays.toString(data));
	}
	
	public static void mergeSort(int[] data) {
		mergeSort(data, 0, data.length - 1);
	}
	
	public static void mergeSort(int[] data, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			mergeSort(data, low, mid);
			mergeSort(data, mid + 1, high);
			merge(data, low, mid, high);
		}
	}
	
	public static void merge(int[] data, int low, int mid, int high) {
		if(low < high) {
			int[] temp = Arrays.copyOf(data, data.length);
			int i, j, k;
			for(i = low, j = mid + 1, k = low; i <= mid && j <= high; k++) {
				if(temp[i] < temp[j]) {
					data[k] = temp[i++];
				}else {
					data[k] = temp[j++];
				}
			}
			while(i <= mid) data[k++] = temp[i++];
			while(j <= high) data[k++] = temp[j++];
		}
	}
}

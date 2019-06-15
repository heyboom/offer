package sort2;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6};
		System.out.println("排序前:" + Arrays.toString(data));
		heapSort(data);
		System.out.println("排序后:" + Arrays.toString(data));
	}
	
	public static void heapSort(int[] data) {
		if (data == null)
			return;
		buildHeap(data);
		int len = data.length;
		for(int i = 0; i < len - 1; i++) {
			int tmp = data[0];
			data[0] = data[len - i - 1];
			data[len - i - 1] = tmp;
			shiftDown(data, 0, len - i - 1);
		}
	}
	
	public static void buildHeap(int[] data) {
		int len = data.length;
		for(int i = data.length/2 - 1; i >= 0; i--) {
			shiftDown(data, i, len);
		}
	}
	
	public static void shiftDown(int[] data, int index, int len) {
		int pivot = data[index];
		int k = index;
		while((k * 2 + 1) < len) {
			int left = k * 2 + 1;
			int max = left;
			if(left + 1 < len && data[left + 1] > data[left]) {
				max = left + 1;
			}
			if (data[max] > pivot) {
				data[k] = data[max];
				k = max;
			} else {
				break;
			}
		}
		data[k] = pivot;
	}
}

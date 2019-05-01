package sort;

import java.util.Arrays;

public class QuickSortDemo {
	
	public static void main(String[] args) {
		int[] data = {9,4,6,5,99,46,88,76,3,77};
		System.out.println("排序前:" + Arrays.toString(data));
		quickSort(data);
		System.out.println("排序后:" + Arrays.toString(data));
	}
	
	public static void quickSort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}
	
	public static void quickSort(int[] data, int low, int high) {
		if(low < high) {
			int pivotpos = partition(data, low, high);
			quickSort(data, low, pivotpos);
			quickSort(data, pivotpos + 1, high);
		}
	}
	
	public static int partition(int[] data, int low, int high) {
			int pivot = data[low];
			while(low < high) {
				while(low < high && data[high] >= pivot) high--;
				data[low] = data[high];
				while(low < high && data[low] <= pivot) low++;
				data[high] = data[low];
			}
			data[low] = pivot;
			return low;
	}
}

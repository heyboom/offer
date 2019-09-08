package paixu;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] num = new int[] {9,4,6,5,99,46,88,76,3,77};
		qs.sort(num);
		System.out.println(Arrays.toString(num));
	}

	//快排
	public void sort(int[] num){
		sort(num, 0, num.length - 1);
	}

	private void sort(int[] num, int low, int high){
		if (low < high){
			int pivotIndex = partition(num, low, high);
			sort(num, low, pivotIndex - 1);
			sort(num, pivotIndex + 1, high);
		}
	}

	private int partition(int[] num, int low, int high){
		makePivotRandom(num, low, high);
		int pivot = num[low];
		while (low < high){
			while(low < high && num[high] >= pivot) high--;
			num[low] = num[high];
			while(low < high && num[low] <= pivot) low++;
			num[high] = num[low];
		}
		num[low] = pivot;
		return low;
	}

	private void makePivotRandom(int[] num, int low, int high){
		Random r = new Random();
		int rIndex = r.nextInt(high - low + 1) + low;
		int tmp = num[low];
		num[low] = num[rIndex];
		num[rIndex] = tmp;
	}


}

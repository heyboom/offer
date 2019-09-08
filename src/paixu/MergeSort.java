package paixu;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] num = new int[] {9,4,6,5,99,46,88,76,3,77};
		ms.sort(num);
		System.out.println(Arrays.toString(num));
	}
	// 归并排
	public void sort(int[] num){
		sort(num, 0, num.length - 1);
	}

	private void sort(int[] num, int low, int high){
		if(low < high){
			int mid = (high - low) / 2 + low;
			sort(num, low, mid);
			sort(num, mid + 1, high);
			merge(num, low, mid, high);
		}
	}

	private void merge(int[] num, int low, int mid, int high){
		int[] copy = new int[num.length];
		for (int i = low; i <= high; i++) copy[i] = num[i];
		int s = low, i = low, j = mid + 1;
		while (i <= mid && j <= high){
			if (copy[i] <= copy[j]){
				num[s++] = copy[i++];
			} else {
				num[s++] = copy[j++];
			}
		}
		while(i <= mid) num[s++] = copy[i++];
		while(j <= mid) num[s++] = copy[j++];
	}

}

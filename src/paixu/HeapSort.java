package paixu;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		HeapSort hs = new HeapSort();
		int[] num = new int[] {9,4,6,5,99,46,88,76,3,77};
		hs.sort(num);
		System.out.println(Arrays.toString(num));
	}
	// 堆排
	public void sort(int[] num){
		buildHeap(num);
		for (int i = num.length - 1; i > 0; i--){
			int tmp = num[i];
			num[i] = num[0];
			num[0] = tmp;
			adjustDown(num, 0, i);
		}
	}

	private void buildHeap(int[] num){
		for (int i = num.length / 2 - 1; i >= 0; i--){
			adjustDown(num, i, num.length);
		}
	}

	private void adjustDown(int[] num, int k, int n){
		while(k < n && 2 * k + 1 < n){
			int parent = num[k];
			int cIndex = 2 * k + 1;
			if (cIndex + 1 < n && num[cIndex + 1] > num[cIndex]) cIndex++;
			int child = num[cIndex];
			if (parent >= child) {
				break;
			}
			int tmp = num[k];
			num[k] = num[cIndex];
			num[cIndex] = tmp;
			k = cIndex;
		}
	}
}

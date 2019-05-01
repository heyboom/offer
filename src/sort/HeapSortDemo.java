package sort;

import java.util.Arrays;

public class HeapSortDemo {
	
	public static void main(String[] args) {
		int[] data = {9,4,6,5,99,46,88,76,3,77};
		System.out.println("排序前:" + Arrays.toString(data));
		heapSort(data);
		System.out.println("排序后:" + Arrays.toString(data));
	}
	
	public static void  heapBuild(int[] data) {
		int len = data.length;
		for(int i = len / 2 - 1; i >= 0; i--) {
			adjustDown(data, i, len);
		}
	}
	
	//建立大顶堆
	public static void adjustDown(int[] data, int pNode, int len) {
		while((pNode * 2 + 1) < len) {
			int left = pNode * 2 + 1;
			int cNode = left;
			if((left + 1) < len && data[left + 1] > data[left]) cNode = left + 1;
			if(data[cNode] > data[pNode]) {
				int temp = data[cNode];
				data[cNode] = data[pNode];
				data[pNode] = temp;
				pNode = cNode;
			} else {
				break;
			}
		}
	}
	
	public static void heapSort(int[] data) {
		heapBuild(data);
		int len = data.length;
		for(int i = len - 1; i > 0; i--) {
			int temp = data[i];
			data[i] = data[0];
			data[0] = temp;
			adjustDown(data, 0, i);
		}
	}
	
}

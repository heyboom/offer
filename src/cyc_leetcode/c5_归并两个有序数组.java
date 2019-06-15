package cyc_leetcode;

public class c5_归并两个有序数组 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] copy = new int[nums1.length];
		for(int i = 0; i < nums1.length; i++) {
			copy[i] = nums1[i];
		}
		int i = 0, j = 0, s = 0;
		while(i < m && j < n) {
			if(copy[i] <= nums2[j]) {
				nums1[s++] = copy[i++];
			} else {
				nums1[s++] = nums2[j++];
			}
		}
		while(i < m) {
			nums1[s++] = copy[i++];
		}
		while(j < n) {
			nums1[s++] = nums2[j++];
		}
	}
}

package cyc_leetcode;

public class 二分查找c4_第一个错误的版本 {

	//12345
	public static void main(String[] args) {
		System.out.println(firstBadVersion(6));
	}
	public static int firstBadVersion(int n) {
		int l = 1, h = n;
		while(l < h) {
			int m = l + (h - l) / 2;
			if (isBadVersion(m)) {
				h = m;
			} else {
				l = m + 1;
			}
		}
		return l;
	}
	
	public static boolean isBadVersion(int version) {
		if(version == 4 || version == 5 || version == 6)
			return true;
		return false;
	}
}

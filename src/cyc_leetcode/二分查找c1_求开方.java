package cyc_leetcode;

public class 二分查找c1_求开方 {

	//注意,m * m 很容易导致溢出
	public int mySqrt(int x) {
		int l = 1, h = x;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (m * m == x) {
				return m;
			} else if (m * m < x) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return h;
	}
	
	//cyc
	public int mySqrt2(int x) {
		int l = 1, h = x;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			int sqrt = x / mid;
			if (sqrt == mid) {
				return mid;
			} else if (mid > sqrt) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return h;
	}
	
	public int mySqrt3(int x) {
		int l = 1, h = x;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid > x / mid) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return h;
	}
}

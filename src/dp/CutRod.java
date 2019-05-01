package dp;

import java.util.Arrays;

/*
 * 钢条切割，详见算法导论
 */

public class CutRod {

	public static void main(String[] args) {
		int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		int n = 4;
		System.out.println(maxBenefit(p, n));
	}
	
	//Bottom-to-up
	public static int maxBenefit(int[] p, int n) {
		int[] r = new int[n + 1];
		r[0] = 0;
		for(int i = 1; i <= n; i++) {
			int q = Integer.MIN_VALUE;
			for(int j = 1; j <= i; j++) {
				q = Math.max(q, p[j - 1] + r[i - j]);
			}
			r[i] = q;
		}
		System.out.println(Arrays.toString(r));
		return r[n];
	}

}

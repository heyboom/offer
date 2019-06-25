package cyc_leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class 贪心c3_投飞镖刺破气球 {

	public int findMinArrowShots(int[][] points) {
		if(points.length == 0)
			return 0;
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int cnt = 1;
		int end = points[0][1];
		for(int i = 1; i < points.length; i++) {
			if (points[i][0] <= end) {
				continue;
			}
			end = points[i][1];
			cnt++;
		}
		return cnt;
	}
}

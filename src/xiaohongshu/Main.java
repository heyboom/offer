package xiaohongshu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] nums = new int[m][n];
		while (k-- != 0) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			nums[i][j] = 1;
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(getMinPath(nums));
	}
	
	private static int getMinPath(int[][] nums) {
		int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int m = nums.length, n = nums[0].length;
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(0, 0));
		int path = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			path++;
			while(size-- > 0) {
				List<Integer> cur = queue.poll();
				int cur_tr = cur.get(0), cur_tc = cur.get(1);
				nums[cur_tr][cur_tc] = 1;
				for(int[] d: direction) {
					int nextRow = cur_tr + d[0], nextColoum = cur_tc + d[1];
					if(nextRow < 0 || nextRow >= m || nextColoum < 0 || nextColoum >= n || nums[nextRow][nextColoum] == 1) {
						continue;
					}
					if(nextRow == m - 1 && nextColoum == n - 1) {
						return path;
					}
					queue.add(Arrays.asList(nextRow, nextColoum));
				}
			}
			
		}
		return 0;
	}
}

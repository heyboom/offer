package xiaohongshu3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int[][] arr = new int[m][m];
		int startR = 0, startC = 0;
		int endR = 0, endC = 0;
		for (int i = 0; i < m; i++) {
			String line = sc.next();
			for(int j = 0; j < m; j++) {
				char c = line.charAt(j);
				if (c == '.') {
					arr[i][j] = 0;
				} else if (c == '#') {
					arr[i][j] = 1;
				} else if (c == 'S') {
					arr[i][j] = 0;
					startR = i;
					startC = j;
				} else if (c == 'E') {
					arr[i][j] = 0;
					endR = i;
					endC = j;
				}
			}
		}
		System.out.println(getMinPath(arr, startR, startC, endR, endC));
	}
	
	private static int getMinPath(int[][] nums, int startR, int startC, int endR, int endC) {
		int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int m = nums.length, n = nums[0].length;
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(startR, startC));
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
					if (nextRow < 0) {nextRow = m - 1;}
					if (nextRow >= m) {nextRow = 0;}
					if (nextColoum < 0) {nextColoum = n - 1;}
					if (nextColoum >= n) {nextColoum = 0;}
					if (nums[nextRow][nextColoum] == 1) {
						continue;
					}
					if(nextRow == endR && nextColoum == endC) {
						return path;
					}
					queue.add(Arrays.asList(nextRow, nextColoum));
				}
			}
			
		}
		return -1;
	}
}

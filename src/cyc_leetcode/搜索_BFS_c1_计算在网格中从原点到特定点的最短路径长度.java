package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * [[1,1,0,1],
 * [1,0,1,0],
 * [1,1,1,1],
 * [1,0,1,1]]
 * 题目描述：1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
public class 搜索_BFS_c1_计算在网格中从原点到特定点的最短路径长度 {

	public static void main(String[] args) {
		int[][] grids = {
				{1,1,0,1},
				{1,0,1,0},
				{1,1,1,1},
				{1,0,1,1}
		};
		System.out.println(minPathLength(grids, 2, 2));
	}
	
	/*
	 * 非递归方式，采用了队列方式存放当前节点
	 */
	public static int minPathLength(int[][] grids, int tr, int tc) {
		final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int m = grids.length, n = grids[0].length;
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(Arrays.asList(0, 0));
		int path = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			path++;
			while(size-- > 0) {
				List<Integer> cur = queue.poll();
				int cur_tr = cur.get(0), cur_tc = cur.get(1);
				grids[cur_tr][cur_tc] = 0;
				for(int[] d: direction) {
					int nr = cur_tr + d[0], nc = cur_tc + d[1];
					if(nr < 0 || nr >= m || nc < 0 || nr >= n || grids[nr][nc] == 0) {
						continue;
					}
					if(nr == tr && nc == tc) {
						return path;
					}
					queue.add(Arrays.asList(nr, nc));
				}
			}
			
		}
		return -1;
	}
}

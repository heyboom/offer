package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 搜索_DFS_c5_能到达太平洋和大西洋的区域 {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		搜索_DFS_c5_能到达太平洋和大西洋的区域 demo = new 搜索_DFS_c5_能到达太平洋和大西洋的区域();
		System.out.println(demo.pacificAtlantic(matrix));
	}

	private int m, n;
	private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	private int[][] matrix;
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> results = new ArrayList<>();
		if(matrix == null || matrix.length == 0) {
			return results;
		}
		this.matrix = matrix;
		m = matrix.length;
		n = matrix[0].length;
		boolean[][] canReachP = new boolean[m][n];
		boolean[][] canReachC = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			dfs(i, 0, canReachP);
			dfs(i, n - 1, canReachC);
		}
		for(int j = 0; j < n; j++) {
			dfs(0, j, canReachP);
			dfs(m - 1, j, canReachC);
		}
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++) {
					if(canReachP[i][j] && canReachC[i][j])
						results.add(Arrays.asList(i, j));
				}
		return results;
	}
	
	private void dfs(int r, int c, boolean[][] canReach) {
		if(canReach[r][c])
			return;
		canReach[r][c] = true;
		for(int[] d : directions) {
			int nextR = r + d[0];
			int nextC = c + d[1];
			if(nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || matrix[r][c] > matrix[nextR][nextC]) {
				continue;
			}
			dfs(nextR, nextC, canReach);
		}
	}
}

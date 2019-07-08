package cyc_leetcode;

public class 搜索_DFS_c2_矩阵中连通分量数目 {

	private int m, n;
	private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		m = grid.length;
		n = grid[0].length;
		int islandNum = 0;
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == '1') {
					dfs(grid, i, j);
					islandNum++;
				}
			}
		return islandNum;
	}
	
	private void dfs(char[][] grid, int r, int c) {
		if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		for(int[] d : directions) {
			dfs(grid, r + d[0], c + d[1]);
		}
	}
}

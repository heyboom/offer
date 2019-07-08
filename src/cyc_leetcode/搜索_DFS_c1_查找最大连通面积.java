package cyc_leetcode;

public class 搜索_DFS_c1_查找最大连通面积 {

	private int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	public int maxAreaOfIsland(int[][] grid) {
		if(grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int maxArea = 0;
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++) {
				maxArea = Math.max(maxArea, dfs(grid, i, j));
			}
		return maxArea;
	}
	
	public int dfs(int[][] grid, int r, int c) {
		if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
			return 0;
		}
		grid[r][c] = 0;
		int area = 1;
		for(int[] d : directions) {
			area += dfs(grid, r + d[0], c + d[1]);
		}
		return area;
	}
}

package cyc_leetcode;

public class 搜索_DFS_c3_好友关系的连通分量数 {
	
	public int findCircleNum(int[][] M) {
		if(M == null || M.length == 0) {
			return 0;
		}
		int n = M.length;
		boolean[] visited = new boolean[n];
		int friendsNum = 0;
		for(int i = 0; i < n; i++) {
				if(!visited[i]) {
					dfs(M, i, visited);
					friendsNum++;
				}
			}
		return friendsNum++;
	}
	
	private void dfs(int[][] M, int i, boolean[] visited) {
		visited[i] = true;
		for(int j = 0; j < M.length; j++) {
			if(M[i][j] == 1 && !visited[j]) {
				dfs(M, j, visited);
			}
		}
	}
}

package cyc_leetcode;

public class 搜索_回溯_c3_在矩阵中寻找字符串 {

	public static void main(String[] args) {
		搜索_回溯_c3_在矩阵中寻找字符串 demo = new 搜索_回溯_c3_在矩阵中寻找字符串();
		char[][] board = {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
		String word = "AAB";
		System.out.println(demo.exist(board, word));
	}
	
	private int m, n;
	private int[][] directions = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
	private boolean[][] visited;
	
	public boolean exist(char[][] board, String word) {
		m = board.length;
		n = board[0].length;
		visited = new boolean[m][n];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++) {
				if(doExist(board, word, 0, i, j)) {
					return true;
				}
			}
		return false;
	}
	
	private boolean doExist(char[][] board, String word, int curLen, int r, int c) {
		if(curLen == word.length()) {
			return true;
		}
		if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(curLen) || visited[r][c]) {
			return false;
		}
		visited[r][c] = true;
		for(int[] d : directions) {
			if(doExist(board, word, curLen + 1, r + d[0], c + d[1])) {
				return true;
			}
		}
		visited[r][c] = false;
		return false;
	}
}

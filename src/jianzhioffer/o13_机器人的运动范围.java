package jianzhioffer;

public class o13_机器人的运动范围 {

	public int movingCount(int threshold, int rows, int cols) {
		if(rows < 1 || cols < 1 || threshold < 1)
			return 0;
		boolean[][] visited = new boolean[rows][cols];
		return movingCount(threshold, 0, rows, 0, cols, visited);
	}
	
	public int movingCount(int threshold, int row, int rows,
			int col, int cols, boolean[][] visited) {
		int count = 0;
		if(row >= 0 && row < rows && col >= 0 && col < cols
				&& !visited[row][col] && check(threshold, row, col)) {
			visited[row][col] = true;
			count = 1 + movingCount(threshold, row, rows, col + 1, cols, visited)
					+ movingCount(threshold, row, rows, col - 1, cols, visited)
					+ movingCount(threshold, row + 1, rows, col, cols, visited)
					+ movingCount(threshold, row - 1, rows, col + 1, cols, visited);
		}
		return count;
	}
	
	public boolean check(int threshold, int row, int col) {
		int count = 0;
		while(row != 0) {
			count += row % 10;
			row /= 10;
		}
		while(col != 0) {
			count += col % 10;
			col /= 10;
		}
		if(count > threshold)
			return false;
		return true;
	}
}

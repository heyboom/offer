package offer;

/*
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class 机器人的运动范围 {

	public int movingCount(int threshold, int rows, int cols) {
		if(threshold < 0 || rows <= 0 || cols <= 0) {
			return 0;
		}
		boolean[] visited = new boolean[rows * cols];
		return movingCountCore(threshold, rows, cols, 0, 0, visited);
	}
	
	public int movingCountCore(int threshold, int rows, int cols, int rowIndex, int colIndex, boolean[] visited) {
		int count = 0;
		if(rowIndex >= 0 && rowIndex < rows && colIndex >= 0 && colIndex < cols
				&& getDigit(rowIndex) + getDigit(colIndex) <= threshold && !visited[rowIndex * cols + colIndex]) {
			visited[rowIndex * cols + colIndex] = true;
			
			count = 1 + movingCountCore(threshold, rows, cols, rowIndex, colIndex + 1, visited)
					  + movingCountCore(threshold, rows, cols, rowIndex, colIndex - 1, visited)
					  + movingCountCore(threshold, rows, cols, rowIndex + 1, colIndex, visited)
					  + movingCountCore(threshold, rows, cols, rowIndex - 1, colIndex, visited);
		}
		return count;
	}
	
	public int getDigit(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}

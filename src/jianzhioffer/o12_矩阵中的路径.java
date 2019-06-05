package jianzhioffer;

public class o12_矩阵中的路径 {

	public static void main(String[] args) {
		char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
		int rows = 3;
		int cols = 4;
		char[] str = {'A','B','C','C','E','D'};
		System.out.println(hasPath(matrix, rows, cols, str));
	}
	
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix == null || rows < 1 || cols < 1 || str == null)
			return false;
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++) {
				boolean[] hasVisited = new boolean[matrix.length];
				int index = 0;
				if(hasPathCore(matrix, i, j, rows, cols, index, str, hasVisited))
					return true;
			}
		return false;
	}
	
	public static boolean hasPathCore(char[] matrix, int row, int col, int rows, int cols, 
											int index, char[] str, boolean[] hasVisited) {
		if(index == str.length)
			return true;
		if(row < 0 || row >= rows || col < 0 || col >= cols)
			return false;
		if(hasVisited[row * cols + col])
			return false;
		if(index >= str.length || matrix[row * cols + col] != str[index])
			return false;
		index++;
		hasVisited[row * cols + col] = true;
		boolean hasPath = hasPathCore(matrix, row , col + 1, rows, cols, index, str, hasVisited)
						|| hasPathCore(matrix, row, col - 1, rows, cols, index, str, hasVisited)
						|| hasPathCore(matrix, row - 1, col, rows, cols, index, str, hasVisited)
						|| hasPathCore(matrix, row + 1, col, rows, cols, index, str, hasVisited);
		if(!hasPath)
			hasVisited[row * cols + col] = false;
		return hasPath;
	}
}

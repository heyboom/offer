package offer;

/*
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class 矩阵中的路径 {

	public static void main(String[] args) {
		char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
		char[] str = {'S','E','E'};
		System.out.println(hasPath(matrix, 3, 4, str));
		
	}
	
	public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		if(matrix == null || rows < 1 || cols < 1 || str == null)
			return false;
		boolean[] visited = new boolean[matrix.length];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(hasPathCore(matrix, rows, cols, str, i, j, 0, visited))
					return true;
			}
		}
		return false;
	}
	
	public static boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,
			int row, int col, int index, boolean[] visited) {
		if(index == str.length)
			return true;
		boolean hasPath = false;
		if(row >= 0 && row < rows && col >= 0 && col < cols && index < str.length
				&& matrix[row * cols + col] == str[index] && !visited[row * cols + col]) {
			visited[row * cols + col] = true;
			
			index++;
			hasPath = hasPathCore(matrix, rows, cols, str, row, col + 1, index, visited)
					|| hasPathCore(matrix, rows, cols, str, row, col - 1, index, visited)
					|| hasPathCore(matrix, rows, cols, str, row + 1, col, index, visited)
					|| hasPathCore(matrix, rows, cols, str, row - 1, col, index, visited);
			
			if(!hasPath) {
				visited[row * cols + col] = false;
			}
		}
		return hasPath;
	}
	
}

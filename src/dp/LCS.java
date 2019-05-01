package dp;

/*
 * 最长公共子序列长度，不一定要连续，详见算法导论P223
 */
public class LCS {

	public static void main(String[] args) {
		System.out.println(lcsLength("ABACD", "ABDSF"));
	}
	
	public static int lcsLength(String str1, String str2) {
		int row = str1.length() + 1;
		int column = str2.length() + 1;
		int[][] c = new int[row][column];
		for(int i = 1; i < row; i++)
			for(int j = 1; j < column; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					c[i][j] = c[i - 1][j - 1] + 1;
				} else {
					c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
				}
			}
		return c[row - 1][column - 1];
	}
}

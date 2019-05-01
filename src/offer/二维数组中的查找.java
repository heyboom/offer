package offer;

public class 二维数组中的查找 {

	public static void main(String[] args) {
		int[][] arr = {{1,2,8,9},{4,7,10,13}};
		System.out.println(Find(7, arr));
	}
	
	public static boolean Find(int target, int [][] array) {
		if(array == null)
			return false;
		int rowLen = array.length;
		int colLen = array[0].length;
		if(rowLen == 0 || colLen == 0) {
			return false;
		}
		for(int i = 0, j = colLen - 1; i < rowLen && j >= 0;) {
			if(target == array[i][j]) {
				return true;
			}
			if(target > array[i][j]) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}

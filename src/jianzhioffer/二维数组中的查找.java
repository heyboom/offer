package jianzhioffer;

public class 二维数组中的查找 {

	public static boolean Find(int target, int [][] array) {
		if(array == null || array.length == 0)
			return false;
		int row = array.length;
		int column = array[0].length;
		int i = 0, j = column - 1;
		while(i < row && j >= 0) {
			if (array[i][j] == target) {
				return true;
			} else if (target < array[i][j]) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}
}

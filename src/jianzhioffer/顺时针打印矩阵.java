package jianzhioffer;
import java.util.ArrayList;

public class 顺时针打印矩阵 {

	public ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list = new ArrayList<>();
		int left = 0;
		int right = matrix[0].length - 1;
		int up = 0;
		int down = matrix.length - 1;
		while(right >= left && down >= up) {
			for(int i = left; i <= right; i++)
				list.add(matrix[up][i]);
			up++;
			if(up > down)	//刚才打印的是仅剩的一行
				break;
			
			for(int j = up; j <= down; j++)
				list.add(matrix[j][right]);
			right--;
			if(right < left)	//刚才打印的是仅剩的一列
				break;
			
			for(int s = right; s >= left; s--)
				list.add(matrix[down][s]);
			down--;
			
			for(int k = down; k >= up; k--)
				list.add(matrix[k][left]);
			left++;
		}
		return list;
	}
}

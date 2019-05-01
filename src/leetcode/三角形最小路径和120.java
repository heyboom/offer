package leetcode;
import java.util.ArrayList;
import java.util.List;
public class 三角形最小路径和120 {
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);list2.add(4);
		List<Integer> list3 = new ArrayList<>();
		list3.add(6);list3.add(5);list3.add(7);
		List<Integer> list4 = new ArrayList<>();
		list4.add(4);list4.add(1);list4.add(8);list4.add(3);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
		triangle.add(list4);
		System.out.println(minimumTotal(triangle));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.get(0) == null || triangle.get(0).isEmpty()) {
			return 0;
		}
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
		for(int i = triangle.size() - 1; i >= 0; i--)
			for(int j = 0; j < triangle.get(i).size(); j++) {
				if(i == triangle.size() - 1 ) {
					dp[i][j] = triangle.get(i).get(j);
				}else {
					dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
				}
			}
		return dp[0][0];
	}
	
//递归解法，复杂度大
//	public int minimumTotal(List<List<Integer>> triangle) {
//		if(triangle == null || triangle.get(0) == null || triangle.get(0).isEmpty()) {
//			return 0;
//		}
//		return minimumTotalCore(triangle, 0, 0);
//	}
//	
//	public int minimumTotalCore(List<List<Integer>> triangle, int row, int index) {
//		if(row == triangle.size() - 1) {
//			return triangle.get(row).get(index);
//		}
//		return triangle.get(row).get(index) 
//				+ Math.min(minimumTotalCore(triangle, row + 1, index), minimumTotalCore(triangle, row + 1, index + 1));
//	}
}

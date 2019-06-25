package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 贪心c4_根据身高和序号重组队列 {

	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		System.out.println(Arrays.deepToString(reconstructQueue2(people)));
	}
	
	public static int[][] reconstructQueue(int[][] people) {
		if(people == null || people.length == 0 || people[0].length == 0)
			return new int[0][0];
		int[][] copy = people;
		Arrays.sort(copy, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]; 
			}
		});
		for(int i = 1; i < copy.length; i++) {
			if (copy[i][0] < copy[i - 1][0]) {
				int index = copy[i][1];
				int[] tmp = copy[i];
				int j = i;
				for(; j > index; j--) {
					copy[j] = copy[j - 1];
				}
				copy[j] = tmp;
			}
		}
		return copy;
	}
	
	//cyc的骚操作
	public static int[][] reconstructQueue2(int[][] people) {
		if(people == null || people.length == 0 || people[0].length == 0)
			return new int[0][0];
		Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
		List<int[]> queue = new ArrayList<>();
		for(int[] p : people) {
			queue.add(p[1], p);
		}
		return queue.toArray(new int[queue.size()][]);
	}
}

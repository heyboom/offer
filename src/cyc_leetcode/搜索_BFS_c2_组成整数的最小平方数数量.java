package cyc_leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 搜索_BFS_c2_组成整数的最小平方数数量 {

	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
	
	public static int numSquares(int n) {
		List<Integer> squares = generateSquares(n);
		Queue<Integer> queue = new LinkedList<>();
		boolean[] marked = new boolean[n + 1];
		queue.offer(n);
		marked[n] = true;
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			level++;
			while(size-- > 0) {
				int cur = queue.poll();
				for(int square : squares) {
					int next = cur - square;
					if(next < 0) {
						break;
					}
					if(next == 0) {
						return level;
					}
					if(marked[next]) {
						continue;
					}
					queue.offer(next);
					marked[next] = true;
				}
			}
		}
		return n;
	}
	
	//1,4,9,16
	private static List<Integer> generateSquares(int n){
		List<Integer> squares = new ArrayList<>();
		int square = 1;
		int diff = 3;
		while(square <= n) {
			squares.add(square);
			square = square + diff;
			diff += 2;
		}
		return squares;
	}
	
	//有整数溢出的风险
	private List<Integer> generateSquares1(int n){
		List<Integer> squares = new ArrayList<>();
		for(int i = 0; i * i <= n; i++) {
				squares.add(i * i);
		}
		return squares;
	}
}

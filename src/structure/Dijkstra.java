package structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {

	private static int M = 10000;
	
	public static void main(String[] args) {
		int[][] weight = {
				{0,4,M,2,M},
				{4,0,4,1,M},
				{M,4,0,1,3},
				{2,1,1,0,7},
				{M,M,3,7,0}
			};
		for(int i = 0; i < weight.length; i++) {
			System.out.println(Arrays.toString(dijkstra(weight, i)));
		}
	}
	
	public static int[] dijkstra(int[][] weight, int start){
		int[][] copy = weight;
		int[] path = new int[copy.length];
		boolean visit[] = new boolean[copy.length];
		path[start] = 0;
		visit[start] = true;
		for(int count = 1; count < copy.length; count++) {
			int k = -1;
			int dmin = Integer.MAX_VALUE;
			for(int i = 0; i < copy.length; i++) {
				if(visit[i] == false && copy[start][i] < dmin) {
					k = i;
					dmin = copy[start][i];
				}
			}
			visit[k] = true;
			path[k] = dmin;
			for(int i = 0; i < copy.length; i++) {
				if(visit[i] == false && path[k] + copy[k][i] < copy[start][i]) {
					copy[start][i] = path[k] + copy[k][i];
				}
			}
		}
		return path;
	}
}

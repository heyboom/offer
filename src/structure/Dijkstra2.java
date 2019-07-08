package structure;

public class Dijkstra2 {

	public static final int M = 10000; // 代表正无穷
	
	public static void main(String[] args) {
		String[] city = {"A", "B", "C", "D", "E"};
		int[][] weight = {
				{0,4,M,2,M},
				{4,0,4,1,M},
				{M,4,0,1,3},
				{2,1,1,0,7},
				{M,M,3,7,0}
		};
		int start = 0;
		int end = 2;
		int[] shortPath = dijkstra(city, weight, start, end);
	}
	
	public static int[] dijkstra(String[] city, int[][] weight, int start, int end) {
		int n = weight.length; // 顶点个数
		int[] shortPath = new int[n]; // 保存start到其他各点的最短路径
		String[] path = new String[n]; // 保存start到其他各点最短路径的字符串表示
		for (int i = 0; i < n; i++) {
			if (weight[start][i] == M) {
				path[i] = new String("不可达");
			} else {
				path[i] = new String(city[start] + "-->" + city[i]);
			}
		}
		
		int[] visited = new int[n];
		shortPath[start] = 0;
		visited[start] = 1;
		
		for (int count = 1; count < n; count++) {
			int k = -1;
			int dmin = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][i] < dmin) {
					dmin = weight[start][i];
					k = i;
				}
			}
			
			shortPath[k] = dmin;
			visited[k] = 1;
			
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
					//修改最短
					weight[start][i] = weight[start][k] + weight[k][i];
					path[i] = path[k] + "-->" + city[i];
				}
			}
		}
		
//		System.out.println("*************************************");
//
//		System.out.println("从" + city[start] + "出发到" + city[end] + ":");
//		System.out.printf("\t最短路径: %s\n", path[end]);
//		System.out.printf("\t最短距离: %d\n", shortPath[end] == M ? -1 : shortPath[end]);
//		System.out.println();
		
		for(int i = 0; i < n; i++) {
			System.out.println("从" + city[start] + "出发到" + city[i] + ":");
			System.out.printf("\t最短路径: %s\n", path[i]);
			System.out.printf("\t最短距离: %d\n", shortPath[i] == M ? -1 : shortPath[i]);
			System.out.println();
		}

		return shortPath;
	}
}

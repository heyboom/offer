package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 这一版本虽然能跑通，但是时间复杂度是O(n3),最终版把findSimilars剥离了出来，思路更清晰
 */
public class 搜索_BFS_c3_最短单词路径初版 {

	public static void main(String[] args) {
		List<String> arrlist = Arrays.asList("hot","dot","dog","lot","log","cog");
		List<String> wordList = new ArrayList<>(arrlist);
		String beginWord = "hit";
		String endWord = "cog";
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int i = 0; 
		while(i < wordList.size() && !wordList.get(i).equals(endWord)) {
			i++; 
		}
		if(i == wordList.size())
			return 0;
		Queue<String> queue = new LinkedList<>();
		boolean[] visited = new boolean[wordList.size()];
		queue.offer(beginWord);
		int len = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			len++;
			while(size-- > 0) {
				String cur = queue.poll();
				List<Integer> similars = findSimilars(cur, wordList, visited);
				if(similars.isEmpty()) {
					continue;
				}
				for(Integer similarIndex : similars) {
					String word = wordList.get(similarIndex);
					if(word.equals(endWord)) {
						return len;
					}
					queue.offer(word);
					visited[similarIndex] = true;
				}
			}
			
		}
		return 0;
	}
	
	private static List<Integer> findSimilars(String beginWord, List<String> wordList, boolean[] visited) {
		List<Integer> similars = new ArrayList<>();
		for(String word : wordList) {
			int diff = 0;
			for(int i = 0; i < word.length() && diff < 2; i++) {
				if(word.charAt(i) != beginWord.charAt(i)) {
					diff++;
				}
			}
			int index = wordList.indexOf(word);
			if(diff == 0) {
				visited[index] = true;
			}
			if(diff < 2 && !visited[index]) {
				similars.add(index);
			}
		}
		return similars;
	}
	
}

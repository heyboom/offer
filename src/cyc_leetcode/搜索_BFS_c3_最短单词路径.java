package cyc_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
 * 还超时...
 */
public class 搜索_BFS_c3_最短单词路径 {
	
	public static void main(String[] args) {
		List<String> arrlist = Arrays.asList("hot","dot","dog","lot","log","cog");
		List<String> wordList = new ArrayList<>(arrlist);
		String beginWord = "hit";
		String endWord = "cog";
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		int end = wordList.indexOf(endWord);
		if(end == -1)
			return 0;
		int begin = wordList.indexOf(beginWord);
		if(begin == -1) {
			wordList.add(beginWord);
		}
		begin = wordList.indexOf(beginWord);
		
		List<Integer>[] similarArray = buildGraphic(wordList);
		return shortPath(begin, end, wordList, similarArray);
	}
	
	private static List<Integer>[] buildGraphic(List<String> wordList) {
		List<Integer>[] similars = new List[wordList.size()];
		for(int i = 0; i < wordList.size(); i++) {
			similars[i] = new ArrayList<>();
			similars[i].addAll(findSimilars(wordList.get(i), wordList));
		}
		return similars;
	}
	
	private static List<Integer> findSimilars(String beginWord, List<String> wordList) {
		List<Integer> similars = new ArrayList<>();
		for(String word : wordList) {
			int diff = 0;
			for(int i = 0; i < word.length() && diff < 2; i++) {
				if(word.charAt(i) != beginWord.charAt(i)) {
					diff++;
				}
			}
			int index = wordList.indexOf(word);
			if(diff == 1) {
				similars.add(index);
			}
		}
		return similars;
	}
	
	private static int shortPath(int begin, int end, List<String> wordList, List<Integer>[] similarArray) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[wordList.size()];
		queue.offer(begin);
		visited[begin] = true;
		int len = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			len++;
			while(size-- > 0) {
				int cur = queue.poll();
				List<Integer> similars = similarArray[cur];
				if(similars.isEmpty()) {
					continue;
				}
				for(Integer similarIndex : similars) {
					if(visited[similarIndex]) {
						continue;
					}
					if(similarIndex == end) {
						return len;
					}
					queue.offer(similarIndex);
					visited[similarIndex] = true;
				}
			}
			
		}
		return 0;
	}
}

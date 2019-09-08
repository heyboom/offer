package xiaohongshu2;
/*
 * 笔记
 * ①输入英文，"(",")",和"<"
 * ②括号内的是注释，忽略，包括括号内的<
 * ③"<"删除前一个字符，但是，如果前一个字符是"("则不影响
 * abc(xyz()<<)<<abc<
 * 输出 abcab
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(getNote(str));
	}
	
	private static String getNote(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		Deque<Character> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int memo = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!checkInput(c)) return "";
			if (c == '(') {
				memo++;
			} else if (c == ')') {
				memo--;
			} else if (memo > 0) {
				continue;
			} else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
				deque.push(c);
			} else if (c == '<') {
				int j;
				for (j = i - 1; j >= 0 && str.charAt(j) == '<'; j--);
				if (j >= 0 && str.charAt(j) == '(') continue;
				if (!deque.isEmpty()) {
					deque.pop();
				}
			}
		}
		while(!deque.isEmpty()) {
			sb.append((deque.pollLast()));
		}
		return sb.toString();
	}
	
	private static boolean checkInput(Character c) {
		if ((c >= 'A' && c <= 'Z') || 
				(c >= 'a' && c <= 'z') ||
				c == '<' ||
				c == '(' ||
				c == ')') {
			return true;
		}
		return false;
	}
}

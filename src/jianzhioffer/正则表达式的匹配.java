package jianzhioffer;

public class 正则表达式的匹配 {

	public static void main(String[] args) {
		char[] str = new char[0];
		char[] pattern = {'.'};
		System.out.println(match(str, pattern));
	}
	
	public static boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null)
			return false;
		return matchCore(str, pattern, 0, 0);
	}
	
	public static boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
		if(strIndex == str.length && patternIndex == pattern.length)
			return true;
		if(strIndex != str.length && patternIndex == pattern.length)
			return false;
		if(patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {
			if(strIndex != str.length && str[strIndex] == pattern[patternIndex] ||
					strIndex != str.length && pattern[patternIndex] == '.') {
				return matchCore(str, pattern, strIndex, patternIndex + 2) ||
						matchCore(str, pattern, strIndex + 1, patternIndex + 2) ||
						matchCore(str, pattern, strIndex + 1, patternIndex);
			}
			return matchCore(str, pattern, strIndex, patternIndex + 2);
		}
		
		if(strIndex != str.length && str[strIndex] == pattern[patternIndex] ||
				strIndex != str.length && pattern[patternIndex] == '.')
			return matchCore(str, pattern, strIndex + 1, patternIndex + 1);
		return false;
	}
}

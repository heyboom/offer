package offer;

/*
 * z请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * z模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * z在本题中，匹配是指字符串的所有字符匹配整个模式。
 * z例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class 正则表达式匹配 {

	public static void main(String[] args) {
		char[] str = {'a','a','a'};
		char[] pattern = {'a','a','*','a'};
		System.out.println(match(str,pattern));
	}
	//未通过
	public static boolean match(char[] str, char[] pattern) {
		if(str == null || pattern == null)
			return false;
		return matchCore(str, pattern, 0, 0);
	}
	
	public static boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {
		//字符和模式都到尾部,匹配成功
		if(strIndex == str.length && patternIndex == pattern.length)
			return true;
		//模式先到尾部,匹配失败
		if(strIndex != str.length && patternIndex == pattern.length)
			return false;
		//模式第二个是"*"
		if(patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
			if((strIndex != str.length && pattern[patternIndex] == '.') 
					|| (strIndex != str.length && str[strIndex] == pattern[patternIndex])) {
				return matchCore(str, pattern, strIndex, patternIndex + 2)
						|| matchCore(str, pattern, strIndex++, patternIndex + 2)
						|| matchCore(str, pattern, strIndex++, patternIndex);
			}else {
				matchCore(str, pattern, strIndex, patternIndex + 2);
			}
		}
		//模式第二个不是"*"
		if((strIndex != str.length && pattern[patternIndex] == '.') 
				|| (strIndex != str.length && pattern[patternIndex] == str[strIndex]))
			return matchCore(str, pattern, strIndex++, patternIndex++);
		return false;
	}
}
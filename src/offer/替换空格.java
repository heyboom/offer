package offer;

public class 替换空格 {

	public String replaceSpace(StringBuffer str) {
		if(str == null) {
			return null;
		}
		int spaceNum = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ')
				spaceNum++;
		}
		int newLen = str.length() + 2 * spaceNum;
		int oldIndex = str.length() - 1;
		int newIndex = newLen - 1;
		str.setLength(newLen);
		for(; oldIndex >=0 && oldIndex < newLen; oldIndex--) {
			if(str.charAt(oldIndex) == ' ') {
				str.setCharAt(newIndex--, '0');
				str.setCharAt(newIndex--, '2');
				str.setCharAt(newIndex--, '%');
			} else {
				str.setCharAt(newIndex--, str.charAt(oldIndex));
			}
		}
		return str.toString();
	}
}

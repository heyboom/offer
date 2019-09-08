package 笔试;
/*
 * 薯队长写了一篇笔记草稿，请你帮忙输出最后内容。

1.输入字符包括英文字符，"(" , ")" 和 "<"。

2.英文字符表示笔记内容。

3. (  ) 之间表示注释内容，任何字符都无效。 括号保证成对出现。

4. "<" 表示退格, 删去前面一个笔记内容字符。 括号不受 "<" 影响 。
 */
public class Test {

	public static Test t1=new Test();

	public Test(){
		System.out.println("init");
	}
	
	{
		System.out.println("blockA");
	}
	
	static {
		System.out.println("blockB");
	}
	
	public static void main(String[] args){
		Test t2=new Test();
	}
}

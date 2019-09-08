package reflect;

public class ClassDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		//获取类对象（JVM加载到内存中的字节码对象）的基本方法
		// ① 类的class属性
		// ② 对象的getClass()方法
		// ③ Class.forName()方法
		Class<TreeNode> clz1 = TreeNode.class;
		Class<TreeNode> clz2 = (Class<TreeNode>) new TreeNode(0).getClass();
		Class<TreeNode> clz3 = (Class<TreeNode>) Class.forName("reflect.TreeNode");
		System.out.println(clz1);
		System.out.println(clz1 == clz2 && clz2 == clz3);
		
		//基本数据类型的类对象获取方式
		//注意，包装类型与基本类型是不一样的
		System.out.println(int.class);
		System.out.println("Integer.class == int.class:" + String.valueOf(Integer.class == int.class));
		
		// 数组的类对象的获取方式
		// 由于数组没有全限定类名，所以无法通过Class.forname()来获取，只能通过①、②方式
		// 一维数组和二维数组的类对象是不同的
		Class<int[]> clzArr1 = int[].class;
		Class<int[]> clzArr2 = (Class<int[]>) new int[] {}.getClass();
		System.out.println(clzArr1);
		System.out.println(clzArr1 == clzArr2);
		Class clzArr3 = int[][].class;
		System.out.println(String.valueOf(clzArr1 == clzArr3));
	}
}

package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

class PUser{
	public PUser() {
		
	}
	
	public void work() {
		System.out.println("PUser.work()");
	}
	
	private void work(String name, int age) {
		System.out.println("PUser.work():" + name + ", " +age);
	}
	
	public static void work(String name) {
		System.out.println("static PUser.work(): " + name);
	}
	
	public <T> List<T> asList(T... a){
		return null;
	}
	
	public void arr(int... a){
		System.out.println(Arrays.toString(a));;
	}
}

public class MethodInvokeDemo {

	public static void main(String[] args) throws Exception {
		Class<PUser> clz = (Class<PUser>) Class.forName("reflect.PUser");
		Method m = clz.getDeclaredMethod("work", String.class, int.class);
		PUser pu = clz.newInstance();
		m.setAccessible(true);
		m.invoke(pu, "will", 17);
		
		// 获取所有非private方法，包括父类
		System.out.println("==============");
		Method[] ms = clz.getMethods();
		for (Method tm : ms) {
			System.out.println(tm);
		}
		
		// 获取当前类中所有声明的方法，包括私有
		System.out.println("==============");
		Method[] ms2 = clz.getDeclaredMethods();
		for (Method tm : ms2) {
			System.out.println(tm);
		}
		
		//调用静态方法只需要将Invoke参数的obj设置为null
		Method mStatic = clz.getMethod("work", String.class);
		mStatic.invoke(null, "will");
		
		// 参数是数组类型，可变变量，invoke时，参数要用Object包裹起来
		System.out.println("==============");
		// T...是数组类型
		Method mFan = clz.getMethod("asList", Object[].class);
		Method marr = clz.getMethod("arr", int[].class);
		marr.invoke(pu, new Object[] {new int[] {1,2,3,4}});
	}
}

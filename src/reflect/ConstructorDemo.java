package reflect;

import java.lang.reflect.Constructor;
import java.util.List;

class User{
	public User() {
		
	}
	
	public User(String name) {
		
	}
	
	private User(String name, int age) {
		
	}
}

public class ConstructorDemo {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<User> clz = User.class;
		
		// 获取无参构造器
		Constructor con = clz.getConstructor();
		System.out.println(con);
		
		// 获取有参构造器
		con = clz.getConstructor(String.class);
		System.out.println(con);
		
		// 获取私有构造器
		con = clz.getDeclaredConstructor(String.class, int.class);
		System.out.println(con);
		
		// 获取所有public构造器
		System.out.println("=================");
		Constructor<?>[] list = clz.getConstructors();
		for (Constructor c : list) {
			System.out.println(c);
		}
		
		// 获取所有的构造器，包括public和private
		System.out.println("=================");
		Constructor<?>[] list2 = clz.getDeclaredConstructors();
		for (Constructor c : list2) {
			System.out.println(c);
		}
	}
	
}

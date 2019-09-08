package reflect;

import java.lang.reflect.Constructor;

class Person{
	public Person() {
		
	}
	
	public Person(String name) {
		System.out.println("构造器 " + name);
	}
	
	private Person(String name, int age) {
		
	}
}

public class CreateObjectDemo {

	// 获取对象的两种方式：
	// ① 通过构造方法
	//    z需要注意，如果是通过私有的构造方法，则需要设置访问权限
	// ② 通过Class类中的newInstance方法
	public static void main(String[] args) throws Exception {
		Class<Person> clz = (Class<Person>) Class.forName("reflect.Person");
		Constructor<Person> con  = clz.getConstructor();
		Person p = con.newInstance();
		System.out.println(p);
		
		Constructor<Person> con2 = clz.getDeclaredConstructor(String.class, int.class);
		// 私有构造器需要将访问权限设置为 true; setAccessible
		// 类似的有： Constructor, Method,Field
		con2.setAccessible(true);
		Person p2 = con2.newInstance("will", 17);
		
		// 如果一个类中有构造器，外界可以直接访问，同时没有参数 ，
		// 那么可以直接使用Class类中的newInstance方法创建对象
		System.out.println(clz.newInstance());
	}
}

package 笔试;

public interface InterfaceTest {

	int a = 1;
	
	void getA();
	
	default void printA() {System.out.println("a: " + a);}
}

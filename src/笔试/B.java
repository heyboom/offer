package 笔试;

public class B extends A{
	  public int a = 1;
	  public void fun(){
	   System.out.println("B");
	  }

	 public static void main(String[] args){
	  A classA = new B();     
	  System.out.println(classA.a);
	  classA.fun();
	 }
}
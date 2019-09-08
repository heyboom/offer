package 笔试;

public class InterfaceClass implements InterfaceTest{

	@Override
	public void getA() {
		printA();
		
	}
	
	public static void main(String[] args) {
		InterfaceClass demo = new InterfaceClass();
		demo.getA();
	}

}

package 笔试;

class X{
	static Y y = new Y();
	Y y2 = new Y();
}

class Y{
	Y(){
		System.out.println("y");
	}
}
public class Z extends X{

	public static void main(String[] args) {
		
	}
}

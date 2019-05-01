package concurrency;

public class 按顺序打印ABC {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			Thread threada = new Thread(() -> {
				System.out.print("A");
			});
			Thread threadb = new Thread(() -> {
				System.out.print("B");
			});
			Thread threadc = new Thread(() -> {
				System.out.print("C");
			});
			try {
				threada.start();
				threada.join();
				threadb.start();
				threadb.join();
				threadc.start();
				threadc.join();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class orderPrintABC extends Thread{
	String name;
	Object lockA = new Object();
	Object lockB = new Object();
	Object lockC = new Object();
	
	public orderPrintABC(String name) {
		this.name = name;
	}
	
	public void run() {
		if(name.equals("A")) {
			synchronized(lockA) {
				synchronized(lockC) {
					System.out.print("A");
				}
			}
		}
	}
}
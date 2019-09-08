package 并发;

public class valotile可见性 {

	private static volatile boolean flag = false;
	
	public static void main(String[] args) {
		Thread ta = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " I am going to run...");
				while (!flag) {
				}
				System.out.println(Thread.currentThread().getName() + " I can run!");
			}
			
		});
		
		Thread tb = new Thread(new Runnable() {

			@Override
			public void run() {
				ready();
				flag = true;
			}
			
		});
		
		ta.start();
		try {
			ta.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tb.start();
	}
	
	public static void ready() {
		System.out.println(Thread.currentThread().getName() + " is ready...");
	}
}

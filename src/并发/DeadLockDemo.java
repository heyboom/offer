package 并发;

public class DeadLockDemo {

	public static void main(String[] args) {
		Object lockA = new Object();
		Object lockB = new Object();
		
		Thread thA = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lockA) {
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(lockB) {
						System.out.println("A: i am ok");
					}
				}
			}
			
		},"A thread");
		Thread thB = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized(lockB) {
					try {
						Thread.currentThread().sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(lockA) {
						System.out.println("B: i am ok");
					}
				}
			}
			
		}, "B thread");
		thA.start();
		thB.start();
	}
}


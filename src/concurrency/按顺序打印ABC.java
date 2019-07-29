package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 按顺序打印ABC {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		Object lockA = new Object();
		Object lockB = new Object();
		Object lockC = new Object();
		Runnable rA = new OrderPrintABC(lockC, lockA, "A");
		Runnable rB = new OrderPrintABC(lockA, lockB, "B");
		Runnable rC = new OrderPrintABC(lockB, lockC, "C");
		threadPool.execute(rA);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadPool.execute(rB);
		threadPool.execute(rC);
		threadPool.shutdown();
	}
	
	private static class OrderPrintABC implements Runnable{

		private Object preLock;
		private Object selfLock;
		private String taskName;
		private int count = 10;
		
		public OrderPrintABC(Object preLock, Object selfLock, String taskName) {
			this.preLock = preLock;
			this.selfLock = selfLock;
			this.taskName = taskName;
		}
		
		@Override
		public void run() {
			while(count > 0) {
				synchronized(preLock) {
					synchronized(selfLock) {
						System.out.print(taskName);
						count--;
						selfLock.notifyAll();
					}
					if(count > 0) {
						try {
							preLock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
}
}


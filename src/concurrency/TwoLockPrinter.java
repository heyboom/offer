package concurrency;

public class TwoLockPrinter {

	public static void main(String[] args) throws InterruptedException {
		Object lockA = new Object();
		Object lockB = new Object();
		Object lockC = new Object();
		
		ThreadGroup group = new ThreadGroup("xx");
		Thread threadA = new Thread(group, new Printer(lockC, lockA, "A"));
		Thread threadB = new Thread(group, new Printer(lockA, lockB, "B"));
		Thread threadC = new Thread(group, new Printer(lockB, lockC, "C"));
		
		threadA.start();
		threadA.sleep(100);		//为什么要sleep?
		threadB.start();
		threadB.sleep(100);
		threadC.start();
		threadC.sleep(100);
		
		while(group.activeCount() > 0) {
			Thread.yield();
		}
	}
}

class Printer implements Runnable {
	private static final int PRINT_COUNT = 10;
	private Object preLock;
	private Object selfLock;
	private String printStr;
	
	public Printer(Object preLock, Object selfLock, String printStr) {
		super();
		this.preLock = preLock;
		this.selfLock = selfLock;
		this.printStr = printStr;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < PRINT_COUNT; i++) {
			synchronized(preLock) {
				synchronized(selfLock) {
					System.out.print(printStr);
					selfLock.notifyAll();
				}
				if(i < PRINT_COUNT) {
					try{
						preLock.wait();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}
package concurrency;

public class StateLockPrinter {

	private static volatile int state = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		ThreadGroup group = new ThreadGroup("xx");
		Thread threadA = new Thread(group, new Printer3(lock, 0, 1, "A"));
		Thread threadB = new Thread(group, new Printer3(lock, 1, 2, "B"));
		Thread threadC = new Thread(group, new Printer3(lock, 2, 0, "C"));
		threadA.start();
		threadA.sleep(1000);
		threadB.start();
		threadB.sleep(1000);
		threadC.start();
		threadC.sleep(1000);
		while(group.activeCount() > 0) {
			Thread.yield();
		}
	}
	
	private static class Printer3 implements Runnable{
		private int PRINT_COUNT = 10;
		private Object lock;
		private String printStr;
		private int printState;
		private int nextPrintSate;
		
		public Printer3(Object lock, int printState, int nextPrintState, String printStr) {
			this.lock = lock;
			this.printState = printState;
			this.nextPrintSate = nextPrintState;
			this.printStr = printStr;
		}
		
		public void run() {
			synchronized(lock) {
				for(int i = 0; i < PRINT_COUNT; i++) {
					while(state != printState) {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.print(printStr);
					state = nextPrintSate;
					lock.notifyAll();
				}
			}
		}
	}
}


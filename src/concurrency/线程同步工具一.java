package concurrency;

import java.util.concurrent.Semaphore;

public class 线程同步工具一 {

	public static void main(String[] args) {
		PrintQueueTB printQueue = new PrintQueueTB();
		Thread[] thread = new Thread[10];
		for(int i = 0; i < 10; i++) {
			thread[i] = new Thread(new JobTB(printQueue));
		}
		for(int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}

class PrintQueueTB {
	
	private final Semaphore semaphore;
	
	public PrintQueueTB() {
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			long duration = (long)(Math.random() * 100);
			System.out.printf("%s: Printing a job during %d\n", 
					Thread.currentThread().getName(), duration);
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}

class JobTB implements Runnable {
	
	private PrintQueueTB printQueue;
	
	public JobTB(PrintQueueTB printQueue) {
		this.printQueue = printQueue;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": Going to print a job");
		printQueue.printJob(new Object());
		System.out.println(Thread.currentThread().getName() + ": The document has been printed.");
	}
}

package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 线程同步工具二 {
	public static void main(String[] args) {
		PrintQueueTB2 printQueue = new PrintQueueTB2();
		Thread[] thread = new Thread[10];
		for(int i = 0; i < 10; i++) {
			thread[i] = new Thread(new JobTB2(printQueue));
		}
		for(int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}

class PrintQueueTB2 {
	private Semaphore semaphore;
	private boolean freePrinters[];
	private Lock lockPrinters;
	
	public PrintQueueTB2() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for(boolean b : freePrinters) {
			b = true;
		}
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob(Object document) {
		try {
			semaphore.acquire();
			int assignedPrinter = getPrinter();
			long duration = (long)(Math.random() * 10);
			System.out.printf("%s: PrintQueue: Print a job in Printer_%d during %d\n",
					Thread.currentThread().getName(), assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPrinter] = true;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}

	private int getPrinter() {
		int ret = -1;
		try {
			lockPrinters.lock();
			for(int i = 0; i < freePrinters.length; i++) {
				if(freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}
}

class JobTB2 implements Runnable {
	
	private PrintQueueTB2 printQueue;
	
	public JobTB2(PrintQueueTB2 printQueue) {
		this.printQueue = printQueue;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": Going to print a job");
		printQueue.printJob(new Object());
		System.out.println(Thread.currentThread().getName() + ": The document has been printed.");
	}
}
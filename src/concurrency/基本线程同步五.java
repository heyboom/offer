package concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 基本线程同步五 {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		Thread[] thread = new Thread[10];
		for(int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread_" + (i + 1));
		}
		for(int i = 0; i < 10; i++) {
			thread[i].start();
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PrintQueue {
	private Lock queueLock = new ReentrantLock(true);
	
	public void printJob (Object document) {
		queueLock.lock();
		try {
			Long duration = (long) Math.random() * 10000;
			System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a job during "
								+ (duration/1000) + "seconds");
			Thread.sleep(duration);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			queueLock.unlock();
		}
		queueLock.lock();
		try {
			Long duration = (long) Math.random() * 10000;
			System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a job during "
								+ (duration/1000) + "seconds");
			Thread.sleep(duration);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			queueLock.unlock();
		}
	}
}

class Job implements Runnable{

	private PrintQueue printQueue;
	
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}
	@Override
	public void run() {
		System.out.printf("%s : Going to print a document\n", Thread.currentThread().getName());
		printQueue.printJob(new Object());
		System.out.printf("%s : The document has been finished\n", Thread.currentThread().getName());
	}
	
}

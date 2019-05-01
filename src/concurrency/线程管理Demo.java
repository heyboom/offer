package concurrency;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class 线程管理Demo {
	public static void main(String[] args) {
		safeTask task = new safeTask();
		for(int i = 0; i < 3; i++) {
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class UnsafeTask implements Runnable{
	private Date startDate;
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread -- %s : %s\n", Thread.currentThread()
				.getId(), startDate);
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread finished -- %s : %s\n", Thread.currentThread()
				.getId(), startDate);
	}
}

class safeTask implements Runnable{
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		protected Date initialValue() {
			return new Date();
		}
	};
	
	public void run() {
		System.out.printf("Starting Thread -- %s : %s\n", Thread.currentThread()
				.getId(), startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finished -- %s : %s\n", Thread.currentThread()
				.getId(), startDate.get());
	}
}

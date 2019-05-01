package concurrency;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class 线程管理十 {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask task = new SearchTask(result);
		for(int i = 0; i < 5; i++) {
			Thread thread = new Thread(group, task);
			thread.start();
			try{
				TimeUnit.SECONDS.sleep(1);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Number of threads : %d\n", group.activeCount());
		System.out.println("Information about the thread group \n");
		group.list();
		Thread[] threads = new Thread[group.activeCount()];
		group.enumerate(threads);
		for(int i = 0; i < group.activeCount(); i++) {
			System.out.printf("Thread %s:%s\n", threads[i].getName(), threads[i].getState());
		}
		waitFinish(group);
		group.interrupt();
	}
	
	private static void waitFinish(ThreadGroup group) {
		while(group.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Result {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class SearchTask implements Runnable {
	private Result result;
	public SearchTask (Result result) {
		this.result = result;
	}
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.printf("Thread %s: Start \n", name);
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException e) {
			System.out.printf("Thread %s : End\n", name);
			return;
		}
		System.out.printf("Thread %s : End\n", name);
	}
	
	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int) (random.nextDouble() * 10);
		System.out.printf("Thread %s : %d\n", Thread.currentThread().getName(), value);
		TimeUnit.SECONDS.sleep(value);
	}
}


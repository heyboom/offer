package concurrency;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 创建线程执行器 {

	public static void main(String[] args) {
		Server server = new Server();
		for(int i = 0; i < 10; i++) {
			Task1 task = new Task1("Task " + i);
			server.executorTask(task);
		}
		server.endServer();
	}
	
}

class Task1 implements Runnable {
	private Date initDate;
	private String name;
	
	public Task1(String name) {
		initDate = new Date();
		this.name = name;
	}
	
	public void run() {
		System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(),
				name, initDate);
		System.out.printf("%s: Task %s: Started on: %s\n",Thread.currentThread().getName(),
				name, new Date());
		try {
			Long duration = (long)(Math.random() * 10);
			System.out.printf("%s: Task %s: Doing a task during %d seconds...\n", Thread.currentThread().getName(),
					name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(),
				name, new Date());
	}
}

class Server{
	private ThreadPoolExecutor executor;
	
	public Server() {
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	}
	
	public void executorTask(Task1 task) {
		System.out.println("Server: A new task has arrived");
		executor.execute(task);
		System.out.printf("Server: Pool Size: %d \n", executor.getPoolSize());
		System.out.printf("Server: Active Count: %d \n", executor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d \n", executor.getCompletedTaskCount());
	}
	
	public void endServer() {
		executor.shutdown();
	}
}

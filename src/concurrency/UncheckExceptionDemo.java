package concurrency;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncheckExceptionDemo implements UncaughtExceptionHandler{

	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("An uncaughtException has been captured");
		System.out.printf("Thread: %s \n", t.getId());
		System.out.printf("Exception: %s : %s \n", e.getClass().getName(), e.getMessage());
		System.out.printf("Stack Trace: \n");
		e.printStackTrace(System.out);
		System.out.printf("Thread status : %s \n", t.getState());
	}
	
	public static void main(String[] args) {
		Thread task = new Task();
		task.setUncaughtExceptionHandler(new UncheckExceptionDemo());
		task.start();
	}
}

class Task extends Thread{
	public void run() {
		Integer s = Integer.valueOf("sdf");
	}
}

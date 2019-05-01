package concurrency;

import java.util.Random;

public class 线程管理十一 {

	public static void main(String[] args) {
		MyThreadGroup group = new MyThreadGroup("MyThreadGroup");
		ExceptionTask task = new ExceptionTask();
		for(int i = 0; i < 2; i++) {
			Thread t = new Thread(group, task);
			t.start();
		}
	}
}

class MyThreadGroup extends ThreadGroup {
	public MyThreadGroup(String name) {
		super(name);
	}
	
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The Thread %s has thrown an Exception \n", t.getId());
		e.printStackTrace(System.out);
		System.out.printf("Terminating the rest of the Threads \n");
		interrupt();
	}
}

class ExceptionTask implements Runnable{

	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while(true) {
			result = 1000 / ((int)(random.nextDouble() * 1000));
			System.out.printf("%s : %f\n", Thread.currentThread().getId(), result);
			if(Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n ", Thread.currentThread().getId());
				return;
			}
		}
	}
	
}
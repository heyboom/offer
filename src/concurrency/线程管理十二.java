package concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class 线程管理十二 {

	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task12 task = new Task12();
		Thread thread;
		System.out.println("Starting the threads...");
		for(int i = 0; i < 10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}
		System.out.println("Factory stats:");
		System.out.println(factory.getStats());
	}
}

class MyThreadFactory implements ThreadFactory{
	private int counter;
	private String name;
	private List<String> stats;
	
	public MyThreadFactory (String name) {
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}
	
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "_Thread_" + counter);
		counter++;
		stats.add(String.format("created thread : Id -- %s  name -- %s  created time -- %s\n", 
				t.getId(), t.getName(), new Date()));
		return t;
	}
	
	public String getStats() {
		StringBuffer sb = new StringBuffer();
		Iterator<String> it = stats.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
			sb.append("\n");
		}
		return sb.toString();
	}
}

class Task12 implements Runnable{
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

package concurrency;

import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable{
	public void run() {
		System.out.println("Source A is loading...");
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Source A has been loaded");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread threadA = new Thread(new DataSourcesLoader());
		Thread threadB = new Thread(new NetWorkConnection());
		threadA.start();
		threadA.join();
		threadB.start();
		threadB.join();
		System.out.println("Configuration has been finished");
	}
}

class NetWorkConnection implements Runnable{
	public void run() {
		System.out.println("NetWorkConnection is working...");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("NetWorkConnection has been finished");
	}
}

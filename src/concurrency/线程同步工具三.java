package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class 线程同步工具三 {

	public static void main(String[] args) {
		VideoConference vc = new VideoConference(10);
		Thread threadVC = new Thread(vc);
		threadVC.start();
		for(int i = 0; i < 10; i++) {
			Thread threadP = new Thread(new Participants(vc, "Thread" + i));
			threadP.start();
		}
	}
}

class VideoConference implements Runnable{
	
	private final CountDownLatch controller;
	
	public VideoConference (int number) {
		controller = new CountDownLatch(10);
	}
	
	public void run() {
		System.out.printf("Vedio Conference: Initialization: %d participants\n",
				controller.getCount());
		try {
			controller.await();
			System.out.println("Vedio Conference: all participants has been arrived.");
			System.out.println("Vedio Conference: Let's started...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void arrive(String name) {
		System.out.println(name + " has arrived.");
		controller.countDown();
		System.out.printf("Vedio Conference: waiting for other %d participants\n", controller.getCount());
	}
}

class Participants implements Runnable{
	private VideoConference vc;
	private String name;
	
	public Participants(VideoConference vc, String name) {
		this.vc = vc;
		this.name = name;
	}
	
	public void run() {
		long duration = (long)(Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		vc.arrive(name);
	}
	
}
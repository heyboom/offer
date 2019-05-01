package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PCBlockingQueue {
	public static void main(String[] args) {
		Resource3 re = new Resource3();
		Thread p1 = new Thread(new Producer3(re), "生产者1");
		Thread p2 = new Thread(new Producer3(re), "生产者2");
		Thread c1 = new Thread(new Consumer3(re), "消费者1");
		Thread c2 = new Thread(new Consumer3(re), "消费者2");
		p1.start();
		p2.start();
		c1.start();
		c2.start();
	}
}

class Resource3 {
	private BlockingQueue resource = new LinkedBlockingQueue(10);
	
	public void add() {
		try {
			resource.put(1);
			Thread.sleep(500);
			System.out.println("生产者" + Thread.currentThread().getName() + "生产了一件商品...");
			System.out.println("资源总数" + resource.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void remove() {
		try {
			resource.take();
			Thread.sleep(500);
			System.out.println("消费者" + Thread.currentThread().getName() + "消费一件商品...");
			System.out.println("资源总数" + resource.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Producer3 implements Runnable{
	private Resource3 re;
	public Producer3(Resource3 re) {
		this.re = re;
	}
	public void run() {
		while(true) {
			re.add();
		}
	}
}

class Consumer3 implements Runnable {
	private Resource3 re;
	public Consumer3(Resource3 re) {
		this.re = re;
	}
	public void run() {
		while(true) {
			re.remove();
		}
	}
}
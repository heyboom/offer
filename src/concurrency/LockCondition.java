package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition conditionP = lock.newCondition();
		Condition conditionC = lock.newCondition();
		Resource2 re = new Resource2(10, lock, conditionP, conditionC);
		
		Thread p1 = new Thread(new Producer2(re), "生产者1");
		Thread p2 = new Thread(new Producer2(re), "生产者2");
		Thread c1 = new Thread(new Consumer2(re), "消费者1");
		Thread c2 = new Thread(new Consumer2(re), "消费者2");
		p1.start();
		p2.start();
		c1.start();
		c2.start();
	}
}

class Resource2 {
	private int size;
	private final int CAPACITY;
	private ReentrantLock lock;
	private Condition conditionP;
	private Condition conditionC;
	
	public Resource2 (int capacity, ReentrantLock lock, Condition conditionP, Condition conditionC) {
		this.CAPACITY = capacity;
		this.lock = lock;
		this.conditionP = conditionP;
		this.conditionC = conditionC;
	}
	
	public void add() throws InterruptedException {
		lock.lock();
		if(size < CAPACITY) {
			size++;
			Thread.sleep(500);
			System.out.println("生产者" + Thread.currentThread().getName() + "生产了一件商品...");
			System.out.println("资源总数" + size);
			conditionC.signalAll();
		}else {
			System.out.println("仓库资源已满，请" + Thread.currentThread().getName() + "等待...");
			conditionP.await();
		}
	}
	
	public void remove() throws InterruptedException {
		lock.lock();
		if(size > 0) {
			size--;
			Thread.sleep(500);
			System.out.println("消费者" + Thread.currentThread().getName() + "消费一件商品...");
			System.out.println("资源总数" + size);
			conditionP.signalAll();
		}else {
			System.out.println("仓库无资源，请" + Thread.currentThread().getName() + "等待...");
			conditionC.await();
		}
	}
}

class Producer2 implements Runnable {
	Resource2 re;
	
	public Producer2(Resource2 re) {
		this.re = re;
	}
	
	public void run() {
		while(true) {
			try {
				re.add();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer2 implements Runnable {
	Resource2 re;
	
	public Consumer2(Resource2 re) {
		this.re = re;
	}
	
	public void run() {
		while(true) {
			try {
				re.remove();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
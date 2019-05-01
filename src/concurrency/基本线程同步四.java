package concurrency;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

//代码运行结果为什么是这样子？：
//为什么在生产者生产了一个产品后,notifyAll()方法没有唤醒消费者,去消费这个产品,而是在所有产品都生成后才去消费呢?
public class 基本线程同步四 {

	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		Thread t1 = new Thread(new Producer12(storage));
		Thread t2 = new Thread(new Consumer12(storage));
		t1.start();
		t2.start();
	}
	
}

class EventStorage {
	private int maxSize;
	private LinkedList<Date> storage;
	
	public EventStorage() {
		maxSize = 10;
		storage = new LinkedList<>();
	}
	
	//可不可以不用wait,notifyAll
	public synchronized void set() {
		while(storage.size() == maxSize) {	//为什么用while
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		Date t = new Date();
		storage.offer(t);
		System.out.println("加入一个事件" + t);
		System.out.println("Set : " + storage.size());
		notifyAll();
	}
	
	public synchronized void get() {
		while(storage.size() == 0) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("减少一个事件" + storage.poll());
		System.out.println("Set : " + storage.size());
		notifyAll();
	}
}

class Producer12 implements Runnable{
	private EventStorage storage;
	
	public Producer12(EventStorage storage) {
		this.storage = storage;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			storage.set();
		}
	}
} 

class Consumer12 implements Runnable{
	private EventStorage storage;
	
	public Consumer12(EventStorage storage) {
		this.storage = storage;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			storage.get();
		}
	}
}
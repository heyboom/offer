package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 生产者消费者 {

	//有界队列
	private static class BoundQueue<T> {
		private Object[] items;
		private int count = 0;
		private Lock lock = new ReentrantLock();
		private Condition notEmpty = lock.newCondition();
		private Condition notFull = lock.newCondition();
		
		public BoundQueue(int size) {
			items = new Object[size];
		}
		
		public void add(T t) throws InterruptedException {
			lock.lock();
			try {
				Long nano = 0L;
				while (count == items.length) {
					if(nano < 0L) {
						return;
					};
					System.out.println("仓库已满");
					notFull.awaitNanos(5000);
				}
				items[count++] = t;
				System.out.println("生产者放入" + t);
				notEmpty.signal();
				Thread.sleep(1000);
			} finally {
				lock.unlock();
			}
		}
		
		public T remove() throws InterruptedException {
			lock.lock();
			T t;
			try {
				Long nano = 0L;
				while (count == 0) {
					if(nano < 0L) {
						return null;
					};
					System.out.println("仓库已空");
					nano = notEmpty.awaitNanos(5000);
				}
				t = (T) items[count - 1];
				items[--count] = null;
				System.out.println("消费者接收" + t);
				notFull.signal();
				Thread.sleep(1000);
			} finally {
				lock.unlock();
			}
			return t;
		}
	}
	
	//生产者
	private static class Product implements Runnable{
		private BoundQueue queue;
		private int count;
		
		public Product (BoundQueue queue, int count) {
			this.queue = queue;
			this.count = count;
		}
		
		public void run() {
			int itr = 1;
			while(itr <= count) {
				try {
					queue.add(itr);
					itr++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//消费者
	private static class Consumer implements Runnable{
		private BoundQueue queue;
		private int count;
		
		public Consumer(BoundQueue queue, int count) {
			this.queue = queue;
			this.count = count;
		}

		@Override
		public void run() {
			int itr = 0;
			while(itr <= count) {
				try {
					queue.remove();
					itr++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BoundQueue<Integer> queue = new BoundQueue<>(5);
		int count = 6;
		Runnable rP = new Product(queue, count);
		Runnable rC = new Consumer(queue, count);
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		threadPool.execute(rP);
		threadPool.execute(rC);
		threadPool.shutdown();
	}
}


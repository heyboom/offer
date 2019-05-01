package concurrency;

public class ProducerConsumerWithWaitNotify {
	
	public static void main(String[] args) {
		Resource re = new Resource(10);
		Thread threadP = new Thread(new Producer(re), "生产者");
		Thread threadP2 = new Thread(new Producer(re), "生产者2");
		Thread threadC = new Thread(new Consumer(re), "消费者");
		threadP.start();
		threadC.start();
		threadP2.start();
	}
}

class Resource {
	private int size;
	private int capacity;
	
	public Resource(int capacity) {
		this.capacity = capacity;
	}
	
	public synchronized void remove() throws InterruptedException {
		if(size > 0) {
			size--;
			Thread.sleep(500);
			System.out.println("消费者" + Thread.currentThread().getName() + "消费一件商品...");
			System.out.println("资源总数" + size);
			notifyAll();
		} else {
			System.out.println("仓库无资源，请" + Thread.currentThread().getName() + "等待...");
			wait();
		}
	}
	
	public synchronized void add() throws InterruptedException {
		if(size < capacity) {
			size++;
			Thread.sleep(500);
			System.out.println("生产者" + Thread.currentThread().getName() + "生产了一件商品...");
			System.out.println("资源总数" + size);
			notifyAll();
		} else {
			System.out.println("仓库资源已满，请" + Thread.currentThread().getName() + "等待...");
			wait();
		}
	}
}

class Producer implements Runnable {
	private Resource re;
	
	public Producer(Resource re) {
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

class Consumer implements Runnable {
	private Resource re;
	
	public Consumer (Resource re) {
		this.re = re;
	}
	
	public void run() {
		while(true) {
			try {
				re.remove();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
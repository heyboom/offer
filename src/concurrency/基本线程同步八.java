package concurrency;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 基本线程同步八 {
	
	public static void main(String[] args) {
		FileMock mock = new FileMock(100, 10);
		Buffer buffer = new Buffer(20);
		Thread threadProducer = new Thread(new Producer8(mock, buffer),"Producer");
		threadProducer.start();
		for(int i = 0; i < 3; i++) {
			Thread threadConsumer = new Thread(new Consumer8(buffer), "Consumer" + i);
			threadConsumer.start();
		}
	}
}

class FileMock{
	private String content[];
	private int index;
	
	public FileMock(int size, int length) {
		content = new String[size];
		for(int i = 0; i < size; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < length; j++) {
				int indice = (int) Math.random() * 255;
				sb.append((char)indice);
			}
			content[i] = sb.toString();
		}
		index = 0;
	}
	
	public boolean hasMoreLine() {
		return index < content.length;
	}
	
	public String getLine() {
		if(hasMoreLine()) {
			System.out.println("Mock: " + (content.length - index));
			return content[index++];
		}
		return null;
	}
}

class Buffer {
	private LinkedList<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition lines;
	private Condition space;
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line) {
		lock.lock();
		try {
			while(buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s : Insert Lines : %d \n", Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public String get() {
		String line = null;
		lock.lock();
		try {
			while((buffer.size()) == 0 &&(hasPendingLines())) {
				lines.await();
			}
			if(hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
			}
			space.signalAll();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return line;
	}

	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}
	
	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}
	
}

class Producer8 implements Runnable{
	private FileMock mock;
	private Buffer buffer;
	
	public Producer8(FileMock mock, Buffer buffer) {
		this.mock = mock;
		this.buffer = buffer;
	}
	
	public void run() {
		buffer.setPendingLines(true);
		while(mock.hasMoreLine()) {
			String line = mock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}
}

class Consumer8 implements Runnable{
	private Buffer buffer;
	
	public Consumer8 (Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		while(buffer.hasPendingLines()) {
			String line = buffer.get();
			processLine(line);
		}
	}
	
	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
package Java并发编程的艺术;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BoundedQueue<T> {
	
	private Object[] items;
	private int addIndex, removeIndex, count;
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	public BoundedQueue(int size) {
		items = new Object[size];
	}
	
	public void add(T t) throws InterruptedException {
		lock.lock();
		try {
			while(addIndex == count) {
				notFull.await();
			}
			items[addIndex++] = t;
			count++;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}
	
	public void remove(T t) throws InterruptedException {
		lock.lock();
		try {
			while(removeIndex == -1) {
				notEmpty.await();
			}
			items[removeIndex--] = null;
			count--;
			notFull.signal();
		} finally {
			lock.unlock();
		}
	}
}

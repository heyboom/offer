package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RcSyncPrinter {

	public static void main(String[] args) throws InterruptedException {
		ThreadGroup group = new ThreadGroup("xx");
		ReentrantLock lock = new ReentrantLock();
		Condition conditionA = lock.newCondition();
		Condition conditionB = lock.newCondition();
		Condition conditionC = lock.newCondition();
		Thread printerA = new Thread(group, new Printer2(lock, conditionA, conditionB, "A"));
		Thread printerB = new Thread(group, new Printer2(lock, conditionB, conditionC, "B"));
		Thread printerC = new Thread(group, new Printer2(lock, conditionC, conditionA, "C"));
		printerA.start();
		printerA.sleep(100);
		printerB.start();
		printerB.sleep(100);
		printerC.start();
		printerC.sleep(100);
		while(group.activeCount() > 0) {
			Thread.yield();
		}
	}
	
}

class Printer2 implements Runnable {
	public final int PRINT_COUNT = 10;
	public ReentrantLock reentrantLock;
	public Condition selfCondition;
	public Condition nextCondition;
	public String printStr;
	
	public Printer2(ReentrantLock reentrantLock, Condition selfCondition, 
			Condition nextCondition, String printStr) {
		this.reentrantLock = reentrantLock;
		this.selfCondition = selfCondition;
		this.nextCondition = nextCondition;
		this.printStr = printStr;
	}
	
	public void run() {
		reentrantLock.lock();
		try {
			for(int i = 0; i < PRINT_COUNT; i++) {
				System.out.print(printStr);
				nextCondition.signal();
				if(i < PRINT_COUNT - 1) {
					try {
						selfCondition.await();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}finally {
			reentrantLock.unlock();
		}
	}
}
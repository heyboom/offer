package concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class 基本线程同步六 {

	public static void main(String[] args) {
		PricesInfo pricesInfo = new PricesInfo();
		Thread[] reader = new Thread[5];
		for(int i = 0; i < 5; i++) {
			reader[i] = new Thread(new Reader(pricesInfo), "Reader" + i);
			reader[i].start();
		}
		Thread writer = new Thread(new Writer(pricesInfo));
		writer.start();
	}
	
}

class PricesInfo{
	private double price1;
	private double price2;
	
	private ReadWriteLock lock;
	
	public PricesInfo(){
		price1 = 1.0;
		price2 = 2.0;
		lock = new ReentrantReadWriteLock();
	}
	
	public double getPrice1() {
		lock.readLock().lock();
		double value = price1;
		lock.readLock().unlock();
		return value;
	}
	
	public double getPrice2() {
		lock.readLock().lock();
		double value = price2;
		lock.readLock().unlock();
		return value;
	}
	
	public void setPrice(double price1, double price2) {
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		lock.writeLock().unlock();
	}
}

class Reader implements Runnable{
	private PricesInfo pricesInfo;
	public Reader(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
			System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
		}
	}
}

class Writer implements Runnable{
	private PricesInfo pricesInfo;
	public Writer(PricesInfo pricesInfo) {
		this.pricesInfo = pricesInfo;
	}
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("Writer: Attempt to modify the prices.");
			pricesInfo.setPrice(Math.random() * 10, Math.random() * 8);
			System.out.println("Writer: Prices have been modified.");
			try {
				Thread.sleep(2);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
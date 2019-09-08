package 并发;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
/**
 * 多人赛跑，并记录跑步时间
 *
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		final CountDownLatch startLatch = new CountDownLatch(1);
		final CountDownLatch endLatch = new CountDownLatch(3);
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					try {
						startLatch.await();
						long start = System.currentTimeMillis();
						System.out.println(Thread.currentThread().getName() + " start at " + start);
						System.out.println(Thread.currentThread().getName() + " is running...");
						Random ra = new Random();
						Thread.sleep(1000 * ra.nextInt(10));
						long end = System.currentTimeMillis();
						System.out.println(Thread.currentThread().getName() + " end at " + end);
						System.out.println(Thread.currentThread().getName() + " cost: " + (end - start));
						endLatch.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
				
			};
			thread.start();
		}
		
		System.out.println("All are ready, GO!");
		startLatch.countDown();
		try {
			endLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Game over");
	}
}

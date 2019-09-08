package 并发;

public class 按顺序打印ABC {

	public static void main(String[] args) throws InterruptedException{
		Object lockA = new Object();
		Object lockB = new Object();
		Object lockC = new Object();
		int count = 10;
		Thread ta = new Thread(new PrintTask(lockC, lockA, "A", count));
		Thread tb = new Thread(new PrintTask(lockA, lockB, "B", count));
		Thread tc = new Thread(new PrintTask(lockB, lockC, "C", count));
		ta.start();
		Thread.sleep(200);
		tb.start();
		tc.start();
	}
	
}

class PrintTask implements Runnable{

	private Object pre;
	private Object cur;
	private int count;
	private String taskName;
	
	public PrintTask(Object pre, Object cur, String taskName, int count) {
		this.pre = pre;
		this.cur = cur;
		this.count = count;
		this.taskName = taskName;
	}
	@Override
	public void run() {
		while (count > 0) {
			synchronized(pre) {
				synchronized(cur) {
					System.out.print(taskName);
					count--;
					cur.notify();
				}
				if (count > 0) {
					try {
						pre.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
package concurrency;

public class Account {

	private double balance;
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	//先读取balance的值，再休息某段时间，这段时间里，balance的值可能会改变，
	//然后再增加amount，就会出现数据不一致现象
	//其实可以balance += amount，这个操作也不是原子操作
	//但是在实践中发现，光写这一句，程序往往执行正确，可能是速度太快，JVM让其恰好在原子操作时间内完成了。
	public  void addAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(1);
			System.out.println(Thread.currentThread().getName() + "存款：" + amount);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		balance = tmp + amount;
	}
	
	public  void subtractAmount(double amount) {
		double tmp = balance;
		try {
			Thread.sleep(1);
			System.out.println(Thread.currentThread().getName() + "取款：" + amount);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		balance = tmp - amount;
	}
	
	public static void main(String[] args) {
		Account t = new Account();
		t.setBalance(1000);
		Thread adder = new Thread(new companyB(t), "adder");
		Thread subber = new Thread(new companyA(t), "suuber");
		System.out.println("账户初始值：" + t.getBalance());
		
		adder.start();
		subber.start();
		
		try {
			adder.join();
			subber.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("账户最终值：" + t.getBalance());
	}
}

class companyA implements Runnable{

	private Account account;
	
	public companyA(Account account) {
		this.account = account;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			account.subtractAmount(1000);
		}
	}
}

class companyB implements Runnable{

	private Account account;
	
	public companyB (Account account) {
		this.account = account;
	}
	
	public void run() {
		for(int i = 0; i < 100; i++)
		account.addAmount(1000);
	}
	
}

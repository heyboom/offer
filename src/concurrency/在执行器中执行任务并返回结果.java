package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 在执行器中执行任务并返回结果 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		List<Future<Integer>> resultList = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < 10; i++) {
			Integer number = random.nextInt(10);
			FactorialCalculator calculator = new FactorialCalculator(number);
			Future<Integer> result = executor.submit(calculator);
			resultList.add(result);
		}
		do {
			System.out.printf("Main: Number of Completed Tasks: %d\n", executor.getCompletedTaskCount());
			for(int i = 0; i < resultList.size(); i++) {
				Future<Integer> result = resultList.get(i);
				System.out.printf("Main: Task %d: %s\n", i, result.isDone());
			}
			try {
				TimeUnit.MICROSECONDS.sleep(50);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}while(executor.getCompletedTaskCount() < resultList.size());
		System.out.println("Main: Results:");
		for(int i = 0; i < resultList.size(); i++) {
			Future<Integer> result = resultList.get(i);
			Integer number = null;
			try {
				number = result.get();
			} catch(InterruptedException e) {
				e.printStackTrace();
			} catch(ExecutionException e) {
				e.printStackTrace();
			}
			System.out.printf("Main: Task %d: %d\n", i, number);
		}
		executor.shutdown();
	}
}

class FactorialCalculator implements Callable<Integer>{
	private Integer number;
	private Integer result;
	public FactorialCalculator(Integer number) {
		this.number = number;
		result = 0;
	}
	public Integer call() throws InterruptedException{
		if(number == 0 || number == 1) {
			result = 1;
		}else {
			result = 1;
			for(int i = 1; i <= number; i++) {
				result *= i;
				TimeUnit.SECONDS.sleep(20);
			}
		}
		System.out.println(Thread.currentThread().getName() + ": " + result);
		return result;
	}
}
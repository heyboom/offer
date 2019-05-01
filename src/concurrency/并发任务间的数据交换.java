package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class 并发任务间的数据交换 {

	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<>();
		List<String> buffer2 = new ArrayList<>();
		Exchanger<List<String>> exchanger = new Exchanger<>();
		Thread producer = new Thread(new ProducerTBB(buffer1, exchanger));
		Thread consumer = new Thread(new ConsumerTBB(buffer2, exchanger));
		producer.start();
		consumer.start();
	}
}


class ProducerTBB implements Runnable{
	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;
	
	public ProducerTBB (List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	
	public void run() {
		int cycle = 1;
		for(int i = 0; i < 10; i++) {
			System.out.println("Producer: Cycle_" + cycle);
			for(int j = 0; j < 10; j++) {
				String message = "Event " + ((i * 10) + j);
				System.out.println("Producer : " + message);
				buffer.add(message);
			}
			System.out.println("Producer: before exchange -- buffer size: " + buffer.size());
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producer: after exchange -- buffer size: " + buffer.size());
			System.out.println("Producer: Cycle_" + cycle + " has been finished.");
			cycle++;
		}
	}
}

class ConsumerTBB implements Runnable{
	private List<String> buffer;
	private final Exchanger<List<String>> exchanger;
	
	public ConsumerTBB(List<String> buffer, Exchanger<List<String>> exchanger) {
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	
	public void run() {
		int cycle = 1;
		for(int i = 0; i < 10; i++) {
			System.out.println("Consumer: Cycle_" + cycle);
			System.out.println("Consumer: before exchange -- buffer size: " + buffer.size());
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consumer: after exchange -- buffer size: " + buffer.size());
			for(int j = 0; j < 10; j++) {
				String message = buffer.get(0);
				System.out.println("Consumer: " + message);
				buffer.remove(0);
			}
			System.out.println("Consumer: Cycle_" + cycle + " has been finished.");
			cycle++;
		}
	}
}
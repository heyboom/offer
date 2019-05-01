package concurrency;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class 线程同步工具四 {

	public static void main(String[] args) {
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEACHER = 5;
		final int PARTICIPANTS = 5;
		final int LINES_PARTICIPANT = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEACHER);
		ResultTB4 results = new ResultTB4(ROWS);
		Grouper grouper = new Grouper(results);
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
		Seacher[] seachers = new Seacher[PARTICIPANTS];
		for(int i = 0; i < PARTICIPANTS; i++) {
			seachers[i] = new Seacher(i * LINES_PARTICIPANT,(i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock,
					results, 5, barrier);
			Thread thread = new Thread(seachers[i]);
			thread.start();
		}
		System.out.println("Main: finished");
	}
}

class MatrixMock{
	private int data[][];
	
	public MatrixMock(int size, int length, int number) {
		int counter = 0;
		data = new int[size][length];
		Random random = new Random();
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < length; j++) {
				data[i][j] = random.nextInt(10);
				if(data[i][j] == number) {
					counter++;
				}
			}
		}
		
		System.out.printf("Mock: There are %d ocurrences of %d in generated data\n",
				counter, number);
	}
	
	public int[] getRow(int row) {
		if(row >= 0 && row < data.length) {
			return data[row];
		}
		return null;
	}
}

class ResultTB4{
	private int[] data;
	public ResultTB4(int size) {
		data = new int[size];
	}
	public int[] getData() {
		return data;
	}
	public void setData(int position, int value) {
		data[position] = value;
	}
}

class Seacher implements Runnable{

	private int firstRow;
	private int lastRow;
	private MatrixMock mock;
	private ResultTB4 results;
	private int number;
	private final CyclicBarrier barrier;
	
	public Seacher(int firstRow, int lastRow, MatrixMock mock,
			ResultTB4 results, int number, CyclicBarrier barrier) {
		this.firstRow = firstRow;
		this.lastRow = lastRow;
		this.mock = mock;
		this.results =results;
		this.number = number;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		int counter;
		System.out.println(Thread.currentThread().getName() + ": Processing lines from " + firstRow +" to " + lastRow);
		for(int i = firstRow; i < lastRow; i++) {
			int row[] = mock.getRow(i);
			counter = 0;
			for(int j = 0; j < row.length; j++) {
				if(row[j] == number) {
					counter++;
				}
			}
			results.setData(i, counter);
		}
		System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());
		try {
			barrier.await();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}catch(BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class Grouper implements Runnable{
	private ResultTB4 results;
	
	public Grouper(ResultTB4 results) {
		this.results = results;
	}
	
	public void run() {
		int finalResult = 0;
		System.out.println("Grouper: Processing results...");
		int data[] = results.getData();
		for(int number : data) {
			finalResult += number;
		}
		System.out.println("Grouper: Total result: " + finalResult);
	}
}
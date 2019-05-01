package sort;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {

	private Integer[] elementData;
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private int size = 0;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	public Heap() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public Heap(int initialCapacity) {
		if(initialCapacity < 1) 
			throw new IllegalArgumentException();
		this.elementData = new Integer[initialCapacity];
	}
	
	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + ((oldCapacity < 64) ?
										(oldCapacity + 2):
										(oldCapacity >> 1));
		if(newCapacity - MAX_ARRAY_SIZE > 0)
			newCapacity = hugeCapacity(minCapacity);
		elementData = Arrays.copyOf(elementData, newCapacity);
	}
	
	private int hugeCapacity(int minCapacity) {
		if(minCapacity < 0)
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ?
				Integer.MAX_VALUE :
					MAX_ARRAY_SIZE;
	}
	
	private void siftUp(int k, Integer num) {
		while(k > 0 && ((k - 1) >> 1) >= 0) {
			int parent = (k - 1) >> 1;
			if(num >= elementData[parent])
				break;
			elementData[k] = elementData[parent];
			k = parent;
		}
		elementData[k] = num;
	}
	
	public boolean offer(Integer num) {
		if(num == null)
			throw new NullPointerException();
		if(size == 0) {
			elementData[0] = num;
			size++;
			return true;
		}
		if(size >= elementData.length)
			grow(size + 1);
		elementData[size] = num;
		siftUp(size, num);
		size++;
		return true;
	}
	
	public Integer peek() {
		if(size == 0)
			return null;
		else
			return elementData[0];
	}
	
	public Integer poll() {
		Integer result = 0;
		if(size == 0)
			return null;
		result = elementData[0];
		elementData[0] = null;
		siftDown(0, elementData[size - 1]);
		elementData[size - 1] = null;
		size--;
		return result;
	}
	
	private void siftDown(int k, Integer num) {
		while(k < size && k * 2 + 2 < size) {
			int child = k * 2 + 1;
			if(child + 1 < size && elementData[child + 1] < elementData[child]){
				child++;
			}
			if(num <= elementData[child])
				break;
			elementData[k] = elementData[child];
			k = child;
		}
		elementData[k] = num;
	}
	
	public String toString() {
		return Arrays.toString(elementData);
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap();
		Integer[] num = {2,1,3,5,4};
		for(Integer n : num) {
			heap.offer(n);
		}
		System.out.println(heap.toString());
		System.out.println(heap.peek());
		System.out.println(heap.toString());
		System.out.println(heap.poll());
		System.out.println(heap.toString());
	}
}

package LRU;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class 简易LRU {

	public static void main(String[] args) {
		LRUCache<Integer, String> lru = new LRUCache<>();
		lru.put(1, "a");
		System.out.println("put 1: " + lru.keySet());
		lru.put(2, "a");
		System.out.println("put 2: " + lru.keySet());
		lru.put(3, "a");
		System.out.println("put 3: " + lru.keySet());
		lru.get(1);
		System.out.println("get 1: " + lru.keySet());
		lru.put(4, "a");
		System.out.println("put 4: " + lru.keySet());
	}
	
}

class LRUCache<K, V> extends LinkedHashMap<K, V>{

	private static final int MAX_ENTRIES = 3;
	
	LRUCache(){
		super(MAX_ENTRIES, 0.75f, true);
	}
	
	@Override
	protected boolean removeEldestEntry(Entry<K, V> eldest) {
		return size() > MAX_ENTRIES;
	}
}
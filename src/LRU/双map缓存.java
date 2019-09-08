package LRU;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class 双map缓存 {

}

class Cache<K, V> {
	private int size;
	private int edenSize;
	private int longtermSize;
	private Map<K, V> eden;
	private Map<K, V> longterm;
	
	public Cache(int size) {
		this.size = size;
		eden = new HashMap<>(size);
		longterm = new WeakHashMap<>(size);
	}
	
	public void get(K k) {
		V v = eden.get(k);
		if (v == null) {
			v = longterm.get(k);
			if (v != null) {
				longterm.remove(k);
				this.eden.put(k, v);
			}
		}
	}
	
	public void put(K k, V v) {
		if (this.eden.size() > edenSize) {
			this.longterm.putAll(this.eden);
			this.eden.clear();
		}
		this.eden.put(k, v);
	}
}
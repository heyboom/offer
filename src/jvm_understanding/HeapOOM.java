package jvm_understanding;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	static class OOMObject{
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000);
		List<OOMObject> list = new ArrayList<>();
		
		while (true) {
			list.add(new OOMObject());
		}
	}
}

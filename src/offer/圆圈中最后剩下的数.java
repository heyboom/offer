package offer;

import java.util.Iterator;
import java.util.LinkedList;

public class 圆圈中最后剩下的数 {

	public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(5, 3));
	}
	
	public static int LastRemaining_Solution(int n, int m) {
		if(n < 1)
			return -1;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			list.add(i);
		}
		Iterator<Integer> itr = list.listIterator();
		int count = 0;
		while(list.size() > 1) {
			if(itr.hasNext()) {
				itr.next();
			}else {
				itr = list.iterator();
				itr.next();
			}
			count++;
			if(count == m) {
				itr.remove();
				count = 0;
			}
		}
		return list.get(0);
	}
	
}

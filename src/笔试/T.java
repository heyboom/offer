package 笔试;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class T {
public static void main(String[] args) throws InterruptedException{
	Thread t = new Thread(new Runnable() {

		@Override
		public void run() {
			int i = 10;
			while(i-- > 0) {
				try {
					Thread.currentThread().sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("ad");
			}
			
		}
	}, "testThread");
	t.start();
	t.join();
	Thread.sleep(20000);
	System.out.println("woshizuizhong dezhuxiancheng");
	
	
}

}

package concurrency;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class 守护进程Demo {

	public static void main(String[] args) {
		Deque deque = new ArrayDeque();
		Thread writer = new WriterTask(deque);
		Thread cleaner = new CleanerTask(deque);
		writer.start();
		cleaner.start();
	}
}

class Event{
	private Date date;
	private String event;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}

class WriterTask extends Thread{
	private Deque<Event> deque;
	
	public WriterTask(Deque deque) {
		this.deque = deque;
	}
	
	public void run() {
		for(int i = 0; i < 20; i++) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("%s has generateed an event %d", Thread.currentThread().getName(), i + 1));
			System.out.println(String.format("%s has generateed an event %d", Thread.currentThread().getName(), i + 1));
			deque.addFirst(event);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class CleanerTask extends Thread{
	private Deque<Event> deque;
	public CleanerTask(Deque<Event> deque) {
		this.deque = deque;
		setDaemon(true);
	}
	public void run() {
		while(true) {
			Date date = new Date();
			clean(date);
		}
	}
	
	private void clean(Date date) {
		  long difference;
		  boolean delete;
		  if (deque.size()==0) {
		    return;
		  }
		  delete=false;
		  do {
		    Event e = deque.getLast();
		    difference = date.getTime() - e.getDate().getTime();
		    if (difference > 10000) {
		     System.out.printf("Cleaner: %s\n",e.getEvent()); deque.removeLast();
		     delete=true;
		    }
		  } while (difference > 10000);
		  if (delete){
		   System.out.printf("Cleaner: Size of the queue: %d\n",deque. size());
		  }
		}

}

package concurrency;

public class 基本线程同步三 {

	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		Thread t1 = new Thread(new TicketOffice1(cinema));
		Thread t2 = new Thread(new TicketOffice2(cinema));
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Room 1 vacancies : " + cinema.getVacancies(1));
		System.out.println("Room 2 vacancies : " + cinema.getVacancies(2));
	}
}

class Cinema {
	private long vacanciesCinema1;
	private long vacanciesCinema2;
	
	private Object controlCinema1;
	private Object controlCinema2;
	
	public Cinema() {
		controlCinema1 = new Object();
		controlCinema2 = new Object();
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}
	
	public boolean sellTickets (int room, int number) {
		if(room == 1) {
			synchronized(controlCinema1) {
				if(number < vacanciesCinema1) {
					vacanciesCinema1 -= number;
					return true;
				} else {
					return false;
				}
			}
		}else {
			synchronized(controlCinema2) {
				if(number < vacanciesCinema2) {
					vacanciesCinema2 -= number;
					return true;
				} else {
					return false;
				}
			}
		}
	}
	
	public boolean returnTickets(int room, int number) {
		if(room == 1) {
			synchronized(controlCinema1) {
				vacanciesCinema1 += number;
				return true;
			}
		}else {
			synchronized(controlCinema2) {
				vacanciesCinema2 += number;
				return true;
			}
		}
	}
	
	public long getVacancies(int room) {
		if(room == 1) {
			return vacanciesCinema1;
		}else {
			return vacanciesCinema2;
		}
	}
}

class TicketOffice1 implements Runnable{
	
	private Cinema cinema;
	
	public TicketOffice1(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public void run() {
		cinema.sellTickets(1, 2);
		cinema.sellTickets(1, 3);
		cinema.sellTickets(1, 4);
		cinema.sellTickets(1, 1);
		cinema.returnTickets(1, 2);
		cinema.sellTickets(1, 2);
		
	}
}

class TicketOffice2 implements Runnable{
	
	private Cinema cinema;
	
	public TicketOffice2(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public void run() {
		cinema.sellTickets(2, 2);
		cinema.sellTickets(2, 3);
		cinema.sellTickets(2, 4);
		cinema.sellTickets(2, 1);
		cinema.returnTickets(2, 2);
		cinema.sellTickets(2, 2);
		
	}
}
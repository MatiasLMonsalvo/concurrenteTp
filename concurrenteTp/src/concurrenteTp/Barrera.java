package concurrenteTp;

public class Barrera {
	private int threads;
	private int hechos = 0;
	
	public Barrera (int threads) {
		this.threads = threads;
	}
	
	public synchronized void hecho() {
		hechos++;
	}

	public synchronized void esperar() {
		while(hechos < threads) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	  this.notifyAll();	
	}

}

/*
 * Activite.java
 *
 * Created on 9 mai 2005, 08:09
 */

package Vue;

import java.io.IOException;

public abstract class Activite implements Runnable {

	private boolean alive;

	private long period;

	public Activite() {
		this.setAlive(true);
		this.setPeriod(25);
	}

	public boolean isAlive() {
		return this.alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public long getPeriod() {
		return this.period;
	}

	public void setPeriod(float period) {
		this.period = (long) period;
	}

	public void start() {
		Thread t = new Thread(this);
		t.start();
	}

	public void stop() {
		this.setAlive(false);
	}

	public void run() {
		try {
			while (this.isAlive()) {
				step();
				Thread.sleep(this.getPeriod());
			}
		} catch (Exception e) {
		}
	}

	protected abstract void step() throws IOException;

}

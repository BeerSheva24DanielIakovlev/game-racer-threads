package telran.multithreading;

import java.time.Instant;
import java.util.Random;

public class Racer extends Thread {
	private Race race;
	private int number;
	private Instant finishTime;

	public Racer(Race race, int number) {
		this.race = race;
		this.number = number;
	}

	@Override
	public void run() {
		int minSleep = race.getMinSleep();
		int maxSleep = race.getMaxSleep();
		int distance = race.getDistance();
		Random random = new Random();
		for (int i = 0; i < distance; i++) {
			try {
				sleep(random.nextInt(minSleep, maxSleep + 1));
				System.out.printf("%d - step %d\n", number, i);
			} catch (InterruptedException e) {
			}
		}
		try {
			race.lock.lock();
			finishTime = Instant.now();
			finishRace();

		} finally {
			race.lock.unlock();
		}
	}

	private void finishRace() {
		race.getResultsTable().add(this);

	}

	public Instant getFinsishTime() {
		return finishTime;

	}

	public int getNumber() {
		return number;
	}
}
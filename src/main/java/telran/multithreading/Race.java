package telran.multithreading;

import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
	private ArrayList<Racer> resultsTable;
	private Instant startTime;
	Lock lock = new ReentrantLock(true);
	public Race(int distance, int minSleep, int maxSleep, ArrayList<Racer> resultsTable, Instant startTime) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
		this.resultsTable = resultsTable;
		this.startTime = startTime;
	}
	public ArrayList<Racer> getResultsTable() {
		return resultsTable;
	}
	public Instant getStartTime() {
		return startTime;
	}
	
	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
}
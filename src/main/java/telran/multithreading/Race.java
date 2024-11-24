package telran.multithreading;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {
    private int distance;
    private int minSleep;
    private int maxSleep;
    private long startTime;
    private final List<String> results = new ArrayList<>();
    private final AtomicInteger placeCounter = new AtomicInteger(1);

    public Race(int distance, int minSleep, int maxSleep) {
        this.distance = distance;
        this.minSleep = minSleep;
        this.maxSleep = maxSleep;
        this.startTime = System.currentTimeMillis();
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

    public long getStartTime() {
        return startTime;
    }

    public synchronized void addResult(int racerNumber, long finishTime) {
        long runningTime = finishTime - startTime;
        results.add(String.format("%-6d %-12d %-15d",
                placeCounter.getAndIncrement(), racerNumber, runningTime));
    }

    public List<String> getResults() {
        return results;
    }
}

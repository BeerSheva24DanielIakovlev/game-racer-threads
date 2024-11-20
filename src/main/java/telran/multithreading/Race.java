package telran.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadLocalRandom;

public class Race {
    private final int distance;
    private final int minSleepTime;
    private final int maxSleepTime;
    private final AtomicInteger winner = new AtomicInteger(0);
    private volatile boolean raceFinished = false;

    public Race(int distance, int minSleepTime, int maxSleepTime) {
        this.distance = distance;
        this.minSleepTime = minSleepTime;
        this.maxSleepTime = maxSleepTime;
    }

    public int getDistance() {
        return distance;
    }

    public int getRandomSleepTime() {
        return ThreadLocalRandom.current().nextInt(minSleepTime, maxSleepTime + 1);
    }

    public boolean setWinner(int racerNumber) {
        boolean isWinnerSet = winner.compareAndSet(0, racerNumber);
        if (isWinnerSet) {
            raceFinished = true;
        }
        return isWinnerSet;
    }

    public int getWinner() {
        return winner.get();
    }

    public boolean isRaceFinished() {
        return raceFinished;
    }
}

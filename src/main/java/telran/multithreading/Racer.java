package telran.multithreading;

public class Racer extends Thread {
    private final Race race;
    private final int number;

    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < race.getDistance(); i++) {
            if (race.isRaceFinished()) {
                System.out.printf("Racer #%d stops running, race is finished.%n", number);
                return;
            }

            System.out.printf("Racer #%d is running... (step %d)%n", number, i + 1);

            try {
                Thread.sleep(race.getRandomSleepTime());
            } catch (InterruptedException e) {
                System.out.printf("Racer #%d was interrupted.%n", number);
                return;
            }
        }

        if (race.setWinner(number)) {
            System.out.printf("Racer #%d has finished first!%n", number);
        }
    }
}



import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;


public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private final Race race;
    private final int speed;
    private final String name;
    private final CountDownLatch countDownLatchStart;
    private final CountDownLatch countDownLatchFinish;
    private final Semaphore semaphore;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public Car(Race race, int speed, CountDownLatch countDownLatchStart, CountDownLatch countDownLatchFinish, Semaphore semaphore) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.countDownLatchStart = countDownLatchStart;
        this.countDownLatchFinish = countDownLatchFinish;
        this.semaphore = semaphore;

    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");


        } catch (Exception e) {
            e.printStackTrace();
        }
        countDownLatchStart.countDown();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        countDownLatchFinish.countDown();
    }
}
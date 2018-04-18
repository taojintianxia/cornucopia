package io.taojintianxia.concurrent.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author nianjun.sun
 */
public class ReentrantLockTest {

    public static void main(String... args) throws InterruptedException {
        LockerWorker lockerWorker = new LockerWorker();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(()->lockerWorker.work());
        executorService.execute(()->lockerWorker.work());
    }
}

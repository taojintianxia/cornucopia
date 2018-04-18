package io.taojintianxia.concurrent.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nianjun.sun
 */
public class LockerWorker {

    private Lock lock = new ReentrantLock();

    private static Integer LOOP_COUNT = 10;

    public void work() {
        lock.lock();
        for (int i = 0; i < LOOP_COUNT; i++) {
            System.out.print(i);
            if (i != LOOP_COUNT - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        lock.unlock();
    }
}

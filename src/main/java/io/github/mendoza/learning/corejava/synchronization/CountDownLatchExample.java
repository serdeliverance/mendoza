package io.github.mendoza.learning.corejava.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    private static class TireWorker extends Thread {

        private final CountDownLatch countDownLatch;

        private TireWorker(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("Changing tire...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Tire changed!");
            countDownLatch.countDown();
        }
    }

    static void main() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        List<TireWorker> workers = new ArrayList<>();
        workers.add(new TireWorker(countDownLatch));
        workers.add(new TireWorker(countDownLatch));
        workers.add(new TireWorker(countDownLatch));
        workers.add(new TireWorker(countDownLatch));

        for (TireWorker worker: workers) {
            worker.start();
        }

        countDownLatch.await(); // waiting for all workers to finish (countDown == 0)
        System.out.println("All tires changed. Maintenance is work is done!");
    }
}

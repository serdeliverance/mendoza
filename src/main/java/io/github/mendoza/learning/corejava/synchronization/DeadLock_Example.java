package io.github.mendoza.learning.corejava.synchronization;

import java.util.Random;

/**
 * Train A     Train B
 * lockA       lockB
 * lockB       lockA ------- dead lock!
 */
public class DeadLock_Example {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        Thread t1 = new Thread(new TrainA(intersection));
        Thread t2 = new Thread(new TrainB(intersection));

        t1.start();
        t2.start();
    }

    private static class TrainA implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainA(Intersection intersection) {
            this.intersection = intersection;
        }


        @Override
        public void run() {
            while(true) {
                long sleep = random.nextInt(10);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                intersection.takeRoadA();
            }
        }
    }

    private static class TrainB implements Runnable {
        private Intersection intersection;
        private Random random = new Random();

        public TrainB(Intersection intersection) {
            this.intersection = intersection;
        }


        @Override
        public void run() {
            while(true) {
                long sleep = random.nextInt(10);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                intersection.takeRoadB();
            }
        }
    }

    private static class Intersection {
        private Object lockA = new Object();
        private Object lockB = new Object();

        public void takeRoadA() {
            synchronized (lockA) {
                System.out.println("Road A is locked by thread " + Thread.currentThread());

                synchronized (lockB) {
                    System.out.printf("Train is passing through road A");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        public void takeRoadB() {
            synchronized (lockB) {
                System.out.println("Road B is locked by thread " + Thread.currentThread());

                synchronized (lockA) {
                    System.out.printf("Train is passing through road B");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

package io.github.mendoza.learning.corejava.synchronization;

import java.util.Random;

public class AtomicOps_Example1 {

    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        Thread metricsPrinter = new MetricsPrinter(metrics);
        Thread businessLogic = new BusinessLogic(metrics);

        metricsPrinter.start();
        businessLogic.start();
    }

    private static class MetricsPrinter extends Thread {
        private Metrics metrics;

        public MetricsPrinter(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                double currentAverage = metrics.getAverage();
                System.out.println("Current average is " + currentAverage);
            }
        }
    }

    private static class BusinessLogic extends Thread {
        private Metrics metrics;
        private Random random = new Random();

        public BusinessLogic(Metrics metrics) {
            this.metrics = metrics;
        }

        @Override
        public void run() {
            while (true) {
                long start = System.currentTimeMillis();

                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                long end = System.currentTimeMillis();
                metrics.addSample(end - start);
            }
        }
    }

    private static class Metrics {
        private long count;

        // Reading double is not an atomic operation, so we need volatile to make that read atomic
        private volatile double average;

        // this ops read and update shared variables, we need to set the method as synchronized
        public synchronized void addSample(double sample) {
            double currentSum = average * count;
            count++;
            this.average = (currentSum + sample) / count;
        }

        public double getAverage() {
            return average;
        }
    }
}

package io.github.mendoza.learning.corejava.synchronization;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Observation: by using the ReentrantReadWriteLock all readers finished in 417 ms,
 * while using the regular ReentrantLock it took 2000 ms.
 */
public class ReentrantReadWriteLock_Example {
    private static final int HIGHEST_PRICE = 10000;

    public static void main(String[] args) throws InterruptedException {
        InventoryDatabase inventoryDatabase = new InventoryDatabase();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
        }

        Thread writer = new Thread(() -> {
            while(true) {
                inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
                inventoryDatabase.removeItem(random.nextInt(HIGHEST_PRICE));

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        writer.setDaemon(true);
        writer.start();

        int numberOfThreads = 7;
        List<Thread> readers = new ArrayList<>();

        for (int readerIndex = 0; readerIndex < numberOfThreads; readerIndex++) {
            Thread reader = new Thread(() -> {
                for (int i = 0; i < 10000; i++) {
                    int upperBoundPrice = random.nextInt(HIGHEST_PRICE);
                    int lowerBoundPrice = upperBoundPrice > 0 ? random.nextInt(upperBoundPrice) : 0;
                    inventoryDatabase.getNumberOfItemsInPriceRange(lowerBoundPrice, upperBoundPrice);
                }
            });

            reader.setDaemon(true);
            readers.add(reader);
        }

        long startReadingTime = System.currentTimeMillis();

        for (Thread reader : readers) {
            reader.start();
        }

        for (Thread reader: readers) {
            reader.join();
        }

        long endReadingTime = System.currentTimeMillis();

        System.out.println(String.format("Reading time: %d ms", endReadingTime - startReadingTime));
    }


    private static class InventoryDatabase {
//        private ReentrantLock lock = new ReentrantLock();
        private ReentrantReadWriteLock wrLock = new ReentrantReadWriteLock();
        private Lock readLock = wrLock.readLock();
        private Lock writeLock = wrLock.writeLock();

        private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();

        public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {
            readLock.lock();
            try {
                Integer fromKey = priceToCountMap.floorKey(lowerBound);
                Integer toKey = priceToCountMap.ceilingKey(upperBound);

                if (fromKey == null || toKey == null) {
                    return 0;
                }

                NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);

                int sum = 0;

                for (int numberOfItemsForPrice : rangeOfPrices.values()) {
                    sum = +numberOfItemsForPrice;
                }

                return sum;
            } finally {
                readLock.unlock();
            }
        }

        public void addItem(int price) {
            writeLock.lock();
            try {
                Integer numberOfItemsPrice = priceToCountMap.get(price);
                if (numberOfItemsPrice == null) {
                    priceToCountMap.put(price, 1);
                } else {
                    priceToCountMap.put(price, numberOfItemsPrice + 1);
                }
            } finally {
                writeLock.unlock();
            }
        }

        public void removeItem(int price) {
            writeLock.lock();
            try {
                Integer numberOfItemsPrice = priceToCountMap.get(price);
                if (numberOfItemsPrice == null || numberOfItemsPrice == 1) {
                    priceToCountMap.remove(price);
                } else {
                    priceToCountMap.put(price, numberOfItemsPrice - 1);
                }
            } finally {
                writeLock.unlock();
            }
        }
    }
}

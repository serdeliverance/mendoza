package io.github.mendoza.learning.corejava.synchronization.ex.tasksync;

import java.util.concurrent.locks.ReentrantLock;

/**
 * I have three task: task 1, task 2 and task 3.
 * I want to run them in a specific order (from 1 to 3).
 */
public class BasicTaskSynchronization {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> System.out.println("Task 1"));
        Thread t2 = new Thread(() -> System.out.println("Task 2"));
        Thread t3 = new Thread(() -> System.out.println("Task 3"));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }
}

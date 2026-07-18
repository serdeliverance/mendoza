package io.github.mendoza.learning.corejava.threads;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    private final List<Runnable> tasks;

    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void executeAll() {

        List<Thread> threads = new ArrayList<>(this.tasks.size());

        for (Runnable task : this.tasks) {
            Thread t = new Thread(task);
            threads.add(t);
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}

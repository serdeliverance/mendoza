package io.github.mendoza.learning.corejava.synchronization.ex.tasksync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// TODO implement it again with synchronized + wait() + notifyAll()
// TODO implement it again with CountDownLatch
public class BasicTaskSynchronization_ex2 {
  private static final ReentrantLock lock = new ReentrantLock();
  private static final Condition cond = lock.newCondition();

  private static int currentStep = 1;

  public static void main(String[] args) {
    Thread t1 = new Thread(new Task("Task 1", 1));
    Thread t2 = new Thread(new Task("Task 2", 2));
    Thread t3 = new Thread(new Task("Task 3", 3));

    t1.start();
    t2.start();
    t3.start();
  }

  private static class Task implements Runnable {
    private String taskName;
    private Integer order;

    public Task(String taskName, Integer order) {
      this.taskName = taskName;
      this.order = order;
    }

    @Override
    public void run() {
      lock.lock();
      try {
        while (currentStep != order) {
          System.out.println("I'm " + Thread.currentThread() + " and I'm waiting...");
          cond.await();
        }
        currentStep++;
        cond.signalAll();
        System.out.println(taskName);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.unlock();
      }
    }
  }
}

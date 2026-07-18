package io.github.mendoza.learning.corejava.threads;

public class Thread01 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                System.out.println("This is the thread: " + Thread.currentThread().getName());
//                System.out.println("Current priority: " + Thread.currentThread().getPriority());
                throw new IllegalArgumentException("boom!");
            }
        });

        thread.setName("WorkerThread01");
        thread.setPriority(Thread.MAX_PRIORITY);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("UncaughtExceptionHandler - catching exception: " + e.getMessage() + " thrown by: " + t.getName());
            }
        });

        System.out.println("This is the thread: " + Thread.currentThread().getName() + " before starting a new thread" );
        thread.start();
        System.out.println("This is the thread: " + Thread.currentThread().getName() + " after starting the new thread");

        Thread.sleep(10000);
    }
}

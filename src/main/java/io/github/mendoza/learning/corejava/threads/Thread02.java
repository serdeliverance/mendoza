package io.github.mendoza.learning.corejava.threads;

public class Thread02 {

    public static void main(String[] args) {
        Thread thread = new MyCustomThread();
        thread.setName("CustomThread");
        thread.start();
    }

    public static class MyCustomThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from " + Thread.currentThread().getName());
        }
    }
}

package com.philemmons;

public class JavaTutThread {

    public static void main(String[] args) {

        // Basically, a thread is a block of code that is execute while another block of code executes.
        Thread c1 = new Thread(new MyThread(), "T1");
        Thread c2 = new Thread(new MyThread(), "T2");
        Thread c3 = new Thread(new MyThread(), "T3");

        c1.start();
        c2.start();
        try {
            c1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c3.start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Active thread: " + Thread.activeCount());
        System.out.println("Start thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End thread: " + Thread.currentThread().getName());
    }

}
